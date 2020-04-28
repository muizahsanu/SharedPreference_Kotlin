package com.example.sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreference.Model.UserModel
import com.example.sharedpreference.SharedPreferences.Preferences
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ketika user menekan button masuk
        btn_masuk_login.setOnClickListener(){
            Login() // memanggil function Login()
        }

        // Ketika user menekan tombol daftar
        tv_daftar_login.setOnClickListener(){
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    fun Login(){
        // Deklarasi variabel
        val username = et_username_login.text.toString() // mengambil value dari EditText username
        val password = et_password_login.text.toString() // mengambil value dari EditText password
        val Preferences = Preferences(baseContext) // Membuat object dari Class Preferences

        // Pengecekan
            // Apakah user sudah terdaftar atau belum
        if(username.equals(Preferences.getRegisteredUser(baseContext)) // mengecek username dari Shared Preferences
            && password.equals(Preferences.getRegisteredPassword(baseContext))){ //mengecek password dari Shared Preferences

            val userModel = UserModel(username,password,"") // membuat objek dari UserModel dan menambahkan data

            // Menyimpan data ke shared preferences
            Preferences.setUserPreferences(baseContext,userModel) //
            Preferences.setLoggedInStatus(baseContext,true)

            // Pindah halaman ke home activity
            startActivity(Intent(baseContext,HomeActivity::class.java))
            finish()
        }
        else{ // kondisi jika user belum terdartar di shared preferences
            Toast.makeText(this,"Belum Regis",Toast.LENGTH_LONG).show()
        }
        // END-Pengecekan
    }
}
