package com.example.androidtask.commons.di.module

import com.example.androidtask.modules.main.di.MainActivityModule
import com.example.androidtask.modules.documents.di.DocumentsFragmentProviderModule
import com.example.androidtask.modules.main.di.MainViewModelModule
import com.example.androidtask.commons.di.scopes.MainScope
import com.example.androidtask.modules.details.di.DetailsFragmentProviderModule
import com.example.androidtask.modules.main.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Yasmine on September,2021
 */
@Module
abstract class ActivitiesBuilderModule {
    @MainScope
    @ContributesAndroidInjector(modules = [
        MainViewModelModule::class,
        DocumentsFragmentProviderModule::class,
        DetailsFragmentProviderModule::class,
        MainActivityModule::class
    ])
    abstract fun contributesInjectMainActivity(): MainActivity

}