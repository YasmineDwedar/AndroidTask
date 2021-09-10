package com.example.androidtask.modules.main.di

import androidx.lifecycle.ViewModel
import com.example.androidtask.commons.di.viewmodel.ViewModelKey
import com.example.androidtask.modules.main.presentation.MainActivityViewModel
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