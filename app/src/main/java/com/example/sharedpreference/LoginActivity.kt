package com.example.sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreference.Model.UserModel
import com.example.sharedpreference.SharedPreferences.Preferences
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = et_username_login.text.toString()
        val password = et_password_login.text.toString()
        val userModel = UserModel(username,password,"")

        val Preferences : Preferences = Preferences(baseContext)
        Preferences.setUserPreferences(baseContext,userModel)
        Preferences.setLoggedInStatus(baseContext,true)

        startActivity(Intent(baseContext,HomeActivity::class.java))
        finish()
    }
}
