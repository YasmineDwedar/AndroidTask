package com.example.androidtask.di.module.main.documents

import androidx.lifecycle.ViewModel
import com.example.androidtask.di.viewmodel.ViewModelKey
import com.example.androidtask.ui.documents.DocumentsFragment
import com.example.androidtask.ui.documents.DocumentsFragmentViewModel
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