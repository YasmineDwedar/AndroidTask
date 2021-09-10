package com.example.androidtask.modules.details.di

import androidx.lifecycle.ViewModel
import com.example.androidtask.commons.di.viewmodel.ViewModelKey
import com.example.androidtask.modules.details.presentation.DetailsFragmentViewModel
import com.example.androidtask.modules.documents.presentation.DocumentsFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
@Module
abstract class DetailsFragmentViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(DetailsFragmentViewModel::class)
    abstract fun bindDetailsFragmentViewModel(detailsFragmentViewModel: DetailsFragmentViewModel): ViewModel
}
