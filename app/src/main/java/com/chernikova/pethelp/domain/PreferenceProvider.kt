package com.chernikova.pethelp.domain

import android.content.Context
import android.content.SharedPreferences


class PreferenceProvider(context: Context) {
    //Нам нужен контекст приложения
    private val appContext = context.applicationContext
    //Создаем экземпляр SharedPreferences
    private val preference: SharedPreferences = appContext.getSharedPreferences("home", Context.MODE_PRIVATE)
    /**
     * Function to save auth token
     */
    fun saveAuthToken(access_token: String) {
        val editor = preference.edit()
        editor.putString(ACCESS_TOKEN, access_token)
        editor.apply()
    }
    /**
     * Function to fetch auth token
     */
    fun getAuthToken(): String? {
        return preference.getString(ACCESS_TOKEN, null)
    }
    companion object {
        const val ACCESS_TOKEN = "access_token"
    }
}