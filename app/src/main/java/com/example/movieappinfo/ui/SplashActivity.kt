package com.example.movieappinfo.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.movieappinfo.R
import com.example.movieappinfo.ui.login.LoginActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.SplashTheme)
        super.onCreate(savedInstanceState)
        navigateToMovie()
    }

    private fun navigateToMovie() {
        val mHandler = Handler(Looper.getMainLooper())
        mHandler.postDelayed({
            val homeIntent = Intent(this@SplashActivity, LoginActivity::class.java)
            homeIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(homeIntent)
        }, 1500)
    }
}