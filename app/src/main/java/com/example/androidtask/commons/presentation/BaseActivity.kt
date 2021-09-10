package com.example.androidtask.commons.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by Yasmine on September,2021
 */
abstract class BaseActivity<VDB : ViewDataBinding, VM : ViewModel>(private val layoutID: Int):
    DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: VM
    var binding: VDB? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutID)
        initializeViewModel()
        setListeners()
        setObservers()
    }

    fun handleErrors(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun initializeViewModel(modelClass: Class<out VM>) {
        viewModel = ViewModelProvider(this, viewModelFactory).get(modelClass)
    }

    fun openActivity(destination: Class<out DaggerAppCompatActivity>) {
        startActivity(Intent(this, destination))
    }

    abstract fun setObservers()
    abstract fun setListeners()
    abstract fun initializeViewModel()



}