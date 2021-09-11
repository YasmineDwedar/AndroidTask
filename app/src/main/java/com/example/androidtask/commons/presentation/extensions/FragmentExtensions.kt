package com.example.androidtask.commons.presentation.extensions

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

/**
 * Created by Yasmine on September,2021
 */
fun <T> Fragment.getNavigationResultLiveData(key: String = "result") =
    findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key)

fun <T> Fragment.setNavigationResult(key: String = "result",result: T) {
    findNavController().previousBackStackEntry?.savedStateHandle?.set(key, result)
}