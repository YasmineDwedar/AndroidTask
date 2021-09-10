package com.example.androidtask.commons.presentation.extensions

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * Created by Yasmine on September,2021
 */

fun View.hide(){
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.makeGoneIf(gone: Boolean) {
    if (!gone) {
        show()
    } else {
        hide()
    }
}
fun View.hideKeyboard() {
    val inputMethodManager: InputMethodManager? =
        context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
    inputMethodManager?.hideSoftInputFromWindow(windowToken, 0)
}