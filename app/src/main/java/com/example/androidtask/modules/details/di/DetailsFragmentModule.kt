package com.example.androidtask.modules.details.di

import com.example.androidtask.commons.di.scopes.DetailsScope
import com.example.androidtask.modules.details.presentation.DetailsFragment
import com.example.androidtask.modules.details.presentation.recyclerview.MainDetailsAdapter
import dagger.Binds
import dagger.Module

@Module
abstract class DetailsFragmentModule {
    @Binds
    @DetailsScope
    abstract fun bindDetailsMainCallBack(detailsFragment: DetailsFragment): MainDetailsAdapter.DetailsMainCallBack
}
