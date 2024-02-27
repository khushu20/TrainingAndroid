package com.example.newapplication.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.newapplication.R
import com.example.newapplication.viewmodel.SplashViewModel

class splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val intent = Intent(this@splash, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}