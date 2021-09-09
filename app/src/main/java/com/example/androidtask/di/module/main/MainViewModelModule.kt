package com.example.androidtask.di.module.main

import androidx.lifecycle.ViewModel
import com.example.androidtask.di.viewmodel.ViewModelKey
import com.example.androidtask.ui.main.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Yasmine on September,2021
 */
@Module
abstract class MainViewModelModule {
    @IntoMap
    @Binds
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel
}