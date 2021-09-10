package com.example.androidtask.modules.details.presentation


import com.example.androidtask.R
import com.example.androidtask.commons.presentation.BaseFragment
import com.example.androidtask.databinding.FragmentDetailsBinding


class DetailsFragment : BaseFragment<FragmentDetailsBinding,DetailsFragmentViewModel>(R.layout.fragment_details) {

    override fun setListeners() {

    }

    override fun setObservers() {
    }

    override fun initializeViewModel() {
        initializeViewModel(DetailsFragmentViewModel::class.java)
    }


}