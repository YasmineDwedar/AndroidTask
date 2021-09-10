package com.example.androidtask.modules.details.di

import com.example.androidtask.commons.di.scopes.DocumentsScope
import com.example.androidtask.modules.details.presentation.DetailsFragment
import com.example.androidtask.modules.documents.di.DocumentsFragmentModule
import com.example.androidtask.modules.documents.di.DocumentsFragmentViewModelModule
import com.example.androidtask.modules.documents.presentation.DocumentsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Yasmine on September,2021
 */
@Module
abstract class DetailsFragmentProviderModule {
    @DetailsScope
    @ContributesAndroidInjector(modules = [DetailsFragmentViewModelModule::class, DetailsFragmentModule::class])
    abstract fun contributesDetailsFragment(): DetailsFragment
}