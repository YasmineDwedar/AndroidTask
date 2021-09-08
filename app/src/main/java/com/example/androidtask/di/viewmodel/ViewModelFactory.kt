package com.example.androidtask.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * Created by Yasmine on September,2021
 */
class ViewModelFactory @Inject constructor(val viewModelsMap : Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModel>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(
        modelClass: Class<T>
    ): T {
        @Suppress("UNCHECKED_CAST")
        var requiredViewModel = viewModelsMap[modelClass]
        if (requiredViewModel == null) {
            val viewModelsMapIterator = viewModelsMap.asIterable()
            requiredViewModel = viewModelsMapIterator.firstOrNull()?.value
            return requiredViewModel as T
        }
        requiredViewModel.let {
            if (modelClass.isAssignableFrom(requiredViewModel::class.java)) {
                return requiredViewModel as T
            }
        }

        throw IllegalArgumentException("Unknown ViewModel class")

    }
}