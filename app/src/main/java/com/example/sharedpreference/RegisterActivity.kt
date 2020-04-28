package com.example.sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreference.Model.UserModel
import com.example.sharedpreference.SharedPreferences.Preferences
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_daftar_register.setOnClickListener(){
            val username = et_username_register.text.toString()
            val password = et_password_register.text.toString()
            val phone = et_phone_register.text.toString()
            val userModel = UserModel(username,password,phone)
            val Preferences : Preferences = Preferences(baseContext)
            Preferences.setUserPreferences(baseContext,userModel)
            Preferences.setLoggedInStatus(baseContext,true)

            startActivity(Intent(baseContext,HomeActivity::class.java))
            finish()
        }
    }
}
