package com.example.androidtask.modules.details.di

import com.example.androidtask.commons.di.scopes.DetailsScope
import com.example.androidtask.modules.details.presentation.DetailsFragment
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