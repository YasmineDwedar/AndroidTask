package com.example.androidtask.ui.documents.presentation


import android.os.Bundle
import com.example.androidtask.R
import com.example.androidtask.base.BaseFragment
import com.example.androidtask.databinding.FragmentDocumentsBinding
import com.example.androidtask.utils.extensions.makeStatusBarTransparent


class DocumentsFragment : BaseFragment<FragmentDocumentsBinding, DocumentsFragmentViewModel>(R.layout.fragment_documents) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().makeStatusBarTransparent()
    }
    override fun setListeners() {

    }

    override fun setObservers() {
    }

    override fun initializeViewModel() {
        initializeViewModel(DocumentsFragmentViewModel::class.java)
    }

}