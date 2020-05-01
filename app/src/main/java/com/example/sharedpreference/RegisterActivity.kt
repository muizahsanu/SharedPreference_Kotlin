package com.example.sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreference.Model.UserModel
import com.example.sharedpreference.SharedPreferences.Preferences
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var sharePref : Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        sharePref = Preferences(baseContext)

        btn_daftar_register.setOnClickListener(){
            val username = et_username_register.text.toString()
            val password = et_password_register.text.toString()
            val repass = et_repassword_register.text.toString()
            if(password == repass){
                val userModel = UserModel(username,password,repass)
                sharePref.setUserPreferences(baseContext,userModel)
                sharePref.setLoggedInStatus(baseContext,true)

                startActivity(Intent(baseContext,HomeActivity::class.java))
                finish()
            }
            else{
                et_repassword_register.error = "Password tidak sama"
            }
        }
    }
}
