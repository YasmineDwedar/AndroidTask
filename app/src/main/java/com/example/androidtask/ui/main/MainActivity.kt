package com.example.androidtask.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtask.R
import com.example.androidtask.base.BaseActivity
import com.example.androidtask.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding,MainActivityViewModel>(R.layout.activity_main) {

    override fun setObservers() {

    }

    override fun setListeners() {

    }

    override fun initializeViewModel() {
        initializeViewModel(MainActivityViewModel::class.java)
    }
}
