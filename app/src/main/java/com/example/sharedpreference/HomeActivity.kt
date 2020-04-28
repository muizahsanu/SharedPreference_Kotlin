package com.example.sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreference.SharedPreferences.Preferences
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //memanggil fungsi declareview
        declareView()

        btn_logout_home.setOnClickListener(){
            // membuat objek dari class Preferences
            val Preferences = Preferences(baseContext)
            // memanggil method set logout dari class preferences
            Preferences.setLogout(baseContext)

            // pindah halaman ke login activty
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }
    fun declareView(){ //memasukin username dari shared preferences ke edit text
        val Preferences = Preferences(baseContext)
        tv_nama_home.text = Preferences.getRegisteredUser(baseContext)
    }
}
