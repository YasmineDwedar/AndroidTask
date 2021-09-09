package com.example.androidtask.di.module.main.documents

import com.example.androidtask.di.scopes.DocumentsScope
import com.example.androidtask.modules.documents.data.service.DocumentsAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Yasmine on September,2021
 */
@Module
class DocumentsFragmentModule {
    companion object{
        @Provides
        @DocumentsScope
        fun provideDocumentsAPI(retrofit: Retrofit):DocumentsAPI=retrofit.create(DocumentsAPI::class.java)
    }
}