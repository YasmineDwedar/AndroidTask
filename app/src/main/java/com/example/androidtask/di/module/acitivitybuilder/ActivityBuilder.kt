package com.example.androidtask.di.module.acitivitybuilder

import com.example.androidtask.di.module.main.MainActivityModule
import com.example.androidtask.di.module.main.MainFragmentBuildersModule
import com.example.androidtask.di.module.main.MainViewModelModule
import com.example.androidtask.di.scopes.MainScope
import com.example.androidtask.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Yasmine on September,2021
 */
@Module
abstract class ActivityBuilderModule {
    @MainScope
    @ContributesAndroidInjector(modules = [MainViewModelModule::class, MainFragmentBuildersModule::class, MainActivityModule::class])
    abstract fun contributesInjectMainActivity(): MainActivity

}