package com.example.androidtask.utils.extensions

import android.content.Context
import androidx.core.content.ContextCompat

/**
 * Created by Yasmine on September,2021
 */
fun Int.getColorInt(context: Context): Int {
    return ContextCompat.getColor(context, this)
}