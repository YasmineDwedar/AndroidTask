package com.example.androidtask.modules.details.presentation


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidtask.R
import com.example.androidtask.commons.data.Constants.ITEM_DETAIL_BUNDLE_KEY
import com.example.androidtask.commons.data.Constants.SELECTED_TEXT
import com.example.androidtask.commons.data.Constants.SELECTED_TEXT_MODE
import com.example.androidtask.commons.presentation.BaseFragment
import com.example.androidtask.commons.presentation.extensions.setNavigationResult
import com.example.androidtask.databinding.FragmentDetailsBinding
import com.example.androidtask.modules.details.presentation.mapper.toBaseDetailsModel
import com.example.androidtask.modules.details.presentation.model.SelectedTextMode
import com.example.androidtask.modules.details.presentation.model.TitleAuthorModel
import com.example.androidtask.modules.details.presentation.recyclerview.MainDetailsAdapter
import com.example.androidtask.modules.documents.presentation.model.DocumentPresentationModel
import javax.inject.Inject


class DetailsFragment : BaseFragment<FragmentDetailsBinding,DetailsFragmentViewModel>(R.layout.fragment_details) ,
    MainDetailsAdapter.DetailsMainCallBack {
    @Inject
    lateinit var mainDetailsAdapter: MainDetailsAdapter

    private val documentDetail: DocumentPresentationModel? by lazy {
        arguments?.getParcelable(ITEM_DETAIL_BUNDLE_KEY)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        submitListToAdapter(documentDetail)
    }
    override fun setListeners() {

    }

    override fun setObservers() {
    }

    override fun initializeViewModel() {
        initializeViewModel(DetailsFragmentViewModel::class.java)
    }
    private fun submitListToAdapter(item :DocumentPresentationModel?) {
        mainDetailsAdapter.submitList(item?.toBaseDetailsModel())
        mainDetailsAdapter.notifyDataSetChanged()

    }

    private fun setUpRecyclerView() {
        binding?.mainDetailRV?.adapter = mainDetailsAdapter


    }

    override fun onTitleClicked(item: TitleAuthorModel?) {
        this.setNavigationResult(SELECTED_TEXT,item?.title)
        this.setNavigationResult(SELECTED_TEXT_MODE,SelectedTextMode.TITLE)
        findNavController().popBackStack()
        Log.d("TAG", item?.title.toString())
    }

    override fun onAuthorClicked(item: TitleAuthorModel?) {
        this.setNavigationResult(SELECTED_TEXT,item?.author)
        this.setNavigationResult(SELECTED_TEXT_MODE,SelectedTextMode.AUTHOR)
        findNavController().popBackStack()
        Log.d("TAG", item?.author.toString())
    }

}