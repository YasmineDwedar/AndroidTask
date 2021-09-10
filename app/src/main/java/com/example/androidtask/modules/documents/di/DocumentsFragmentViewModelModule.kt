package com.example.androidtask.modules.documents.di

import androidx.lifecycle.ViewModel
import com.example.androidtask.commons.di.viewmodel.ViewModelKey
import com.example.androidtask.modules.documents.presentation.DocumentsFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Yasmine on September,2021
 */
@Module
abstract class DocumentsFragmentViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(DocumentsFragmentViewModel::class)
    abstract fun bindDocumentsFragmentViewModel(documentsFragmentViewModel: DocumentsFragmentViewModel): ViewModel
}