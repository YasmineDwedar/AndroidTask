package com.example.androidtask.commons.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created by Yasmine on September,2021
 */
abstract class BaseFragment<VDB: ViewDataBinding,VM: ViewModel>(val layoutID:Int) : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM
    var binding: VDB? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,layoutID,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViewModel()
        setListeners()
        setObservers()
    }
    override fun onDestroy() {
        super.onDestroy()
    }

    fun openNewActivity(activityClass: Class<out DaggerAppCompatActivity>){
        (activity as BaseActivity<*, *>).openActivity(activityClass)
    }

    fun initializeViewModel(modelClass:Class<out VM>){
        viewModel= ViewModelProvider(this,viewModelFactory).get(modelClass)
    }
    abstract fun setListeners()
    abstract fun setObservers()
    abstract fun initializeViewModel()
}