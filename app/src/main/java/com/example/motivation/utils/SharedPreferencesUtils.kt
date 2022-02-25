package com.example.motivation.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesUtils(context: Context)  {

    private val mSharedPreferences =
        context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        mSharedPreferences.edit().putString(key, value).apply()
    }

    fun restoreString(key: String): String {
        return mSharedPreferences.getString(key,key) ?: ""
    }

}




