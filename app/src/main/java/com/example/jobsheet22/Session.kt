package com.example.jobsheet22

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast

class Session(context: Context) {
    private val USERNAME_KEY = "key_username"
    private val NAMALENGKAP_KEY = "key_nama_lengkap"

    private var preferences: SharedPreferences = context.getSharedPreferences("Login App", Context.MODE_PRIVATE)

    fun getUser(): String? {
        return preferences.getString(NAMALENGKAP_KEY, null)
    }

    fun setSession(username: String?, nama_lengkap: String?) {
        preferences.edit().putString(USERNAME_KEY, username)
            .apply()

        preferences.edit().putString(NAMALENGKAP_KEY, nama_lengkap)
            .apply()
    }

    fun isLoggedIn(): Boolean {
        val username = preferences.getString(USERNAME_KEY, null)
        return username != null
    }

    fun validate(username: String, password: String?): Boolean {
        val namalengkap = "M.KHUSNU MAROM"
        if (username == "Admin" && password == "Admin234") {
            setSession(username, namalengkap)
            return true
        } else if (username == "Radiva" && password == "Radiva234") {
            setSession(username, namalengkap)
            return true
        } else if (username == "2000" && password == "2000") {
            setSession(username, namalengkap)
            return true
        } else if (username == "KHUSNU" && password == "KHUSNU234") {
            setSession(username, namalengkap)
            return true
        }
        return false
    }
    fun logout() {
        preferences.edit().remove(USERNAME_KEY)
            .remove(NAMALENGKAP_KEY)
            .apply()
    }
}