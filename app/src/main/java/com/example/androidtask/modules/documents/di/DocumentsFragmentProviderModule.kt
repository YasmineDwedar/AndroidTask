package com.example.androidtask.modules.documents.di

import com.example.androidtask.commons.di.scopes.DocumentsScope
import com.example.androidtask.modules.documents.presentation.DocumentsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Yasmine on September,2021
 */
@Module
abstract class DocumentsFragmentProviderModule {
    @DocumentsScope
    @ContributesAndroidInjector(modules = [DocumentsFragmentViewModelModule::class, DocumentsFragmentModule::class])
    abstract fun contributesDocumentsFragment(): DocumentsFragment
}