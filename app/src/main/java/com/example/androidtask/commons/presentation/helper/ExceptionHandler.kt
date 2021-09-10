package com.example.androidtask.commons.presentation.helper

import android.accounts.NetworkErrorException
import androidx.lifecycle.MutableLiveData
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by Yasmine on September,2021
 */
object ExceptionHandler {
    fun parseException(exception:Throwable, networkState: MutableLiveData<String>){
        when(exception){
            is IOException -> networkState.postValue("Something went wrong ")
            is NetworkErrorException -> networkState.postValue("Network Error..")
            is java.lang.Exception -> networkState.postValue("An error occurred!")
            is UnknownHostException -> networkState.postValue("Please Check You internet connection")
            is SocketTimeoutException ->networkState.postValue("Something went wrong")
            is ConnectException ->networkState.postValue("Something went wrong")
            else ->  networkState.postValue("Something went wrong")
        }
    }
}