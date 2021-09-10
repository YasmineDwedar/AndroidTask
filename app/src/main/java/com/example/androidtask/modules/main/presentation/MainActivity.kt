package com.example.androidtask.modules.main.presentation

import com.example.androidtask.R
import com.example.androidtask.commons.presentation.BaseActivity
import com.example.androidtask.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>(R.layout.activity_main) {

    override fun setObservers() {

    }

    override fun setListeners() {

    }

    override fun initializeViewModel() {
        initializeViewModel(MainActivityViewModel::class.java)
    }
}
