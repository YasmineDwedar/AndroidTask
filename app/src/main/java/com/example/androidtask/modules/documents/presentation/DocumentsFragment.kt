package com.example.androidtask.modules.documents.presentation


import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.lifecycle.lifecycleScope
import com.example.androidtask.R
import com.example.androidtask.commons.presentation.BaseFragment
import com.example.androidtask.databinding.FragmentDocumentsBinding
import com.example.androidtask.modules.documents.presentation.model.BaseDocumentsModel
import com.example.androidtask.modules.documents.presentation.recyclerview.DocumentsAdapter
import com.example.androidtask.commons.presentation.extensions.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject


class DocumentsFragment : BaseFragment<FragmentDocumentsBinding, DocumentsFragmentViewModel>(R.layout.fragment_documents) {

    @Inject
    lateinit var documentsAdapter: DocumentsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().makeStatusBarTransparent()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
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
                    } else {
                        noResultsTv.show()
                        documentsRV.hide()
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
        //binding?.documentsRV?.addOnScrollListener(scrollListner)
    }

    private fun submitToAdapter(list: List<BaseDocumentsModel>) {
        documentsAdapter.submitList(list)
        documentsAdapter.notifyDataSetChanged()
    }


}