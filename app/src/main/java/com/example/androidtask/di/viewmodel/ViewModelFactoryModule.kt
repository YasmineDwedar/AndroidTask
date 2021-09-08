package com.example.androidtask.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * Created by Yasmine on September,2021
 */

@Module
abstract class ViewModelFactoryModule {
    @Binds                                                         ///implementation                 //interface
    abstract fun bindViewModelProviderFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}