package com.chernikova.pethelp


import android.content.Context
import android.content.SharedPreferences


class PreferenceProvider(context: Context) {

    private var preferences: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val TOKEN = "token"
    }

    /**
     * Function to save auth token
     */
    fun saveAuthToken(token: String) {
        val editor = preferences.edit()
        editor.putString(TOKEN, token)
        editor.apply()
    }

    /**
     * Function to fetch auth token
     */
    fun getAuthToken(): String? {
        return preferences.getString(TOKEN, null)
    }
}
