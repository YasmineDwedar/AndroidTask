package com.example.androidtask.di.module.main

import com.example.androidtask.di.module.main.documents.DocumentsFragmentModule
import com.example.androidtask.di.module.main.documents.DocumentsFragmentViewModelModule
import com.example.androidtask.di.scopes.DocumentsScope
import com.example.androidtask.ui.documents.DocumentsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Yasmine on September,2021
 */
@Module
abstract class MainFragmentBuildersModule {
    @DocumentsScope
    @ContributesAndroidInjector(modules = [DocumentsFragmentViewModelModule::class, DocumentsFragmentModule::class])
    abstract fun contributesDocumentsFragment(): DocumentsFragment
}