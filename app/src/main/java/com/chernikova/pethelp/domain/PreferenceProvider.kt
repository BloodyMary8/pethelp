package com.chernikova.pethelp.domain

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit


class PreferenceProvider(context: Context) {
    //Нам нужен контекст приложения
    private val appContext = context.applicationContext
    //Создаем экземпляр SharedPreferences
    private val pref: SharedPreferences = appContext.getSharedPreferences("help", Context.MODE_PRIVATE)
    /**
     * Function to save auth token
     */
    fun saveAuthToken(access_token: String) {
        val editor = pref.edit()
        editor.putString(ACCESS_TOKEN, access_token)
        editor.apply()
    }
    /**
     * Function to fetch auth token
     */
    fun getAuthToken(): String? {
        return pref.getString(ACCESS_TOKEN, null)
    }

    companion object {
        const val ACCESS_TOKEN = "access_token"

    }

}

