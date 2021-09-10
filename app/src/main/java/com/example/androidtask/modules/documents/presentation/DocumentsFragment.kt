package com.example.androidtask.modules.documents.presentation


import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtask.R
import com.example.androidtask.commons.presentation.BaseFragment
import com.example.androidtask.databinding.FragmentDocumentsBinding
import com.example.androidtask.modules.documents.presentation.model.BaseDocumentsModel
import com.example.androidtask.modules.documents.presentation.recyclerview.DocumentsAdapter
import com.example.androidtask.commons.presentation.extensions.*
import com.example.androidtask.modules.documents.presentation.model.DocumentPresentationModel
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.Circle
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject


class DocumentsFragment : BaseFragment<FragmentDocumentsBinding, DocumentsFragmentViewModel>(R.layout.fragment_documents),
    DocumentsAdapter.DocumentsMainCallBack {

    @Inject
    lateinit var documentsAdapter: DocumentsAdapter
    var isLoading = false
    var isScrolling = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().makeStatusBarTransparent()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        hideCircularProgressBar()
    }
    override fun setListeners() {
        binding?.apply {
            searchEt.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    v.hideKeyboard()
                    return@OnEditorActionListener true
                }
                false
            })
           /* lifecycleScope.launchWhenResumed {
                searchEt.onTextChangedWithDebounce().debounce(600L).collect {
                    performSearch(it)
                }
            }*/
        }
    }

    override fun setObservers() {
        lifecycleScope.launchWhenStarted {
            binding?.apply {
                viewModel.documentsStateFlow.collect {
                    if (it.isNotEmpty()) {
                        noResultsTv.hide()
                        documentsRV.show()
                        submitToAdapter(it)
                        hideCircularProgressBar()
                    } else {
                        noResultsTv.show()
                        documentsRV.hide()
                    }
                }
            }
        }
        lifecycleScope.launchWhenCreated {
            binding?.apply {
                viewModel.hasNextStateFlow.collect {
                    if (!it) {
                        hideCircularProgressBar()
                    }
                }
            }
        }

    }

    override fun initializeViewModel() {
        initializeViewModel(DocumentsFragmentViewModel::class.java)
        binding?.also {
            it.vm = viewModel
            it.lifecycleOwner = viewLifecycleOwner
        }
    }
    private fun setUpRecyclerView() {
        binding?.documentsRV?.adapter = documentsAdapter
        binding?.documentsRV?.addOnScrollListener(scrollListner)
    }

    private fun submitToAdapter(list: List<BaseDocumentsModel>) {
        documentsAdapter.submitList(list)
        documentsAdapter.notifyDataSetChanged()
    }
    private fun showCircularProgressBar() {
        val doubleBounce: Sprite = Circle()
        binding?.progressBar?.setIndeterminateDrawable(doubleBounce)
        binding?.progressBar?.visibility = View.VISIBLE
        isLoading=true
    }

    private fun hideCircularProgressBar() {
        binding?.progressBar?.visibility = View.GONE
        isLoading = false
    }
    fun onScrollPage() {
        viewModel.getDocumentsSearchResults()
    }
    val scrollListner = object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (dy > 0) {
                try {
                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                    val visibleItemCount = layoutManager.findLastCompletelyVisibleItemPosition()+1
                    if (visibleItemCount == layoutManager.itemCount && viewModel.hasNext){
                        onScrollPage()
                        showCircularProgressBar()
                        Log.d("TAG", "onScrolled: ${visibleItemCount} lastVisibleItemPosition:${layoutManager.itemCount}")
                        isScrolling = false
                    }

                } catch (ex: Exception) {}
            }
        }
    }










    override fun onItemClicked(item: DocumentPresentationModel) {

    }


}