package com.example.androidtask.modules.documents.di

import com.example.androidtask.commons.di.scopes.DocumentsScope
import com.example.androidtask.modules.documents.data.repository.DocumentsRepoImpl
import com.example.androidtask.modules.documents.data.retrofit.service.DocumentsAPI
import com.example.androidtask.modules.documents.domain.repository.DocumentsRepo
import com.example.androidtask.modules.documents.presentation.DocumentsFragment
import com.example.androidtask.modules.documents.presentation.recyclerview.DocumentsAdapter
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Yasmine on September,2021
 */
@Module
abstract class DocumentsFragmentModule {
    companion object{
        @Provides
        @DocumentsScope
        fun provideDocumentsAPI(retrofit: Retrofit):DocumentsAPI=retrofit.create(DocumentsAPI::class.java)

    }

    @Binds
    @DocumentsScope
    abstract fun bindsDocumentsRepo(documentsRepoImpl: DocumentsRepoImpl):DocumentsRepo

    @Binds
    @DocumentsScope
    abstract fun bindDocumentsMainCallBack(documentsFragment: DocumentsFragment): DocumentsAdapter.DocumentsMainCallBack
}