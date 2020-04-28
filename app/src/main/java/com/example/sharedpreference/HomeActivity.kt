package com.example.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreference.SharedPreferences.Preferences
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        declareView()
    }
    fun declareView(){
        val Preferences = Preferences(baseContext)
        tv_nama_home.text = Preferences.getRegisteredUser(baseContext)
    }
}
