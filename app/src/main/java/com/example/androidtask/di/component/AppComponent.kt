package com.example.androidtask.di.component

import android.app.Application
import com.example.androidtask.application.BaseApplication
import com.example.androidtask.di.module.app.AppModule
import com.example.androidtask.di.module.acitivitybuilder.ActivityBuilderModule
import com.example.androidtask.di.viewmodel.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Yasmine on September,2021
 */
@Singleton
@Component(modules = [AppModule::class,
    AndroidSupportInjectionModule::class
    ,ViewModelFactoryModule::class,
    ActivityBuilderModule::class])

interface AppComponent: AndroidInjector<BaseApplication> {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application):Builder
        fun build():AppComponent
    }
}