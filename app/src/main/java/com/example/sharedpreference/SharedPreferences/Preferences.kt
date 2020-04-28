package com.example.sharedpreference.SharedPreferences

import android.content.Context
import com.example.sharedpreference.Model.UserModel

class Preferences(private var context: Context): UtilStatic{
    private val PREF_SESSION = "com.example.sharedpreference.session"
    private var REGISTER_USERNAME = "REGISTER_USERNAME"
    private val REGISTER_PASSWORD = "REGISTER_PASSWORD"
    private val REGITSER_PHONE = "REGISTER_PHONE"
    private val LOGIN_STATUS = "LOGIN_STATUS"

    fun setUserPreferences(context: Context, userModel: UserModel) {
        val sharedPref = context.getSharedPreferences(PREF_SESSION,Context.MODE_PRIVATE)
        with(sharedPref.edit()){
            this.putString(REGISTER_USERNAME, userModel.username)
            this.putString(REGISTER_PASSWORD, userModel.password)
            this.putString(REGITSER_PHONE, userModel.phone)
            this.apply()
        }
    }
    fun getRegisteredUser(context: Context):String?{
        val sharedPref = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE)
        return sharedPref.getString(REGISTER_USERNAME,DEFAULT_STRING)
    }
    fun getRegisteredPassword(context: Context): String? {
        val sharedPref = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE)
        return sharedPref.getString(REGISTER_PASSWORD,DEFAULT_STRING)
    }
    fun getRegisteredPhone(context: Context): String?{
        val sharedPref = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE)
        return sharedPref.getString(REGITSER_PHONE,DEFAULT_STRING)
    }

    fun setLoggedInStatus(context: Context, statusLogin:Boolean){
        val sharedPref = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE)
        with(sharedPref.edit()){
            this.putBoolean(LOGIN_STATUS,statusLogin)
            this.apply()
        }
    }
    fun getLoggedInStatus(context: Context):Boolean?{
        val sharedPref = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE)
        return sharedPref.getBoolean(LOGIN_STATUS,DEFAULT_BOOLEAN)
    }
    fun setLogout(context: Context){
        val sharedPref = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE)
        with(sharedPref.edit()){
            this.remove(LOGIN_STATUS)
            this.apply()
        }
    }
}