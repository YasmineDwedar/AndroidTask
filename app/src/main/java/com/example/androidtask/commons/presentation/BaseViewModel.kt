package com.example.androidtask.commons.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtask.commons.presentation.helper.ExceptionHandler.parseException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by Yasmine on September,2021
 */
open class BaseViewModel : ViewModel() {
    private var _networkState = MutableLiveData<String>()
    val networkState: LiveData<String>
        get() = _networkState

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        parseException(exception,_networkState)
    }

    fun launchSafeCoroutine(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(exceptionHandler) {
            block()
        }
    }

}