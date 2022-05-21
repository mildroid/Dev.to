package com.mildroid.devto.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

fun Any?.log(msg: Any? = "") {
    Log.d("bandOfBrothers", "$msg -> $this")
}

fun Context.pref(prefKey: String = "app_pref"): SharedPreferences {
    return getSharedPreferences(prefKey, Context.MODE_PRIVATE)
}
