package com.example.sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreference.Model.UserModel
import com.example.sharedpreference.SharedPreferences.Preferences
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var sharePref : Preferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharePref = Preferences(baseContext)

        // Ketika user menekan button masuk
        btn_masuk_login.setOnClickListener(){
            val username = et_username_login.text.toString()
            val password = et_password_login.text.toString()
            validasiForm(username,password)
        }

        // Ketika user menekan tombol daftar
        tv_daftar_login.setOnClickListener(){
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun Login(user: String,pass: String){
        // Membuat objek dari UserModel dan mengisi parameter yang ada di class data UserModel
        val userModel = UserModel(user,pass,"")

        // Menyimpan data ke shared preferences
        sharePref.setUserPreferences(baseContext,userModel) //
        sharePref.setLoggedInStatus(baseContext,true)

        // Pindah halaman ke home activity
        startActivity(Intent(baseContext,HomeActivity::class.java))
        finish()
    }

    // Fungsi pengecekan username
    fun cekUser(user: String):Boolean{
        // Membandingkan value dari edit text dengan data Shared Preferences
        return user.equals(sharePref.getRegisteredUser(baseContext)) // Ini akan mereturnkan Boolean (true/false)
    }

    // Fungsi pengecekan password
    fun cekPass(pass: String): Boolean{
        // Membandingkan value dari edit text dengan data Shared Preferences
        return pass.equals(sharePref.getRegisteredPassword(baseContext)) // Ini akan mereturnkan Boolean (true/false)
    }

    // Validasi Form
    fun validasiForm(user:String,pass: String){
        if(user.isEmpty()){
            et_username_login.error = "username tidak boleh kosong"
            return
        }
        if(pass.isEmpty()){
            et_password_login.error = "password tidak boleh kosong"
            return
        }

        // Memeriksa apakah username dan password sudah ada di data shared preferences
        // Jika ya maka memanggil fungsi login
        // Jika tidak maka menampilkan Toast Message
        if(cekUser(user) == true && cekPass(pass)){
            Login(user,pass) //memanggil function Login()
        }
        else{
            Toast.makeText(baseContext,"Mohon Register Terlebih Dahulu",Toast.LENGTH_LONG).show()
        }
    }
}
