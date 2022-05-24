package com.mildroid.devto.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.compose.ui.graphics.Color

fun Any?.log(msg: Any? = "") {
    Log.d("bandOfBrothers", "$msg -> $this")
}

fun Context.pref(prefKey: String = "app_pref"): SharedPreferences {
    return getSharedPreferences(prefKey, Context.MODE_PRIVATE)
}

/**
 * Color hex string to [Color].
 */
val String.toColor
    get() = Color(android.graphics.Color.parseColor(this))