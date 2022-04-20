package com.ateeshkumar.activitylifecyle

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private var titleName:String? = "avenger"
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrollview)
        println("onCreate action")
        try {
            titleName = sharedPreferences.getString("Title", "The Aventure")
        }catch (e:UninitializedPropertyAccessException){
            titleName = "Ateesh"
        }

        title= titleName
    }

    override fun onStart() {
        super.onStart()
        println("Start action")
    }

    override fun onResume() {
        super.onResume()
        println("onResume action")
    }

    override fun onPause() {
        super.onPause()
        println("onPause action")
    }

    override fun onStop() {
        super.onStop()
        println("onStop action")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy action")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart action")
    }
}