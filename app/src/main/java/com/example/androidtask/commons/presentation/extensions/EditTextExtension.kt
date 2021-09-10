package com.example.androidtask.commons.presentation.extensions

import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

/**
 * Created by Yasmine on September,2021

 */
fun EditText.onTextChangedWithDebounce(): Flow<String> = callbackFlow {

    this@onTextChangedWithDebounce.doAfterTextChanged {
        offer(it.toString())
    }
    awaitClose { this@onTextChangedWithDebounce.addTextChangedListener(null) }

}