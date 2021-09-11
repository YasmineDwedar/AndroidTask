package com.example.androidtask.modules.details.di

import com.example.androidtask.commons.di.scopes.DocumentsScope
import com.example.androidtask.modules.details.presentation.DetailsFragment
import com.example.androidtask.modules.details.presentation.recyclerview.MainDetailsAdapter
import com.example.androidtask.modules.documents.presentation.DocumentsFragment
import com.example.androidtask.modules.documents.presentation.recyclerview.DocumentsAdapter
import dagger.Binds
import dagger.Module

@Module
abstract class DetailsFragmentModule {
    @Binds
    @DetailsScope
    abstract fun bindDetailsMainCallBack(detailsFragment: DetailsFragment): MainDetailsAdapter.DetailsMainCallBack
}
