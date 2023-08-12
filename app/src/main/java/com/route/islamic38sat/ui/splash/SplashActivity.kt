package com.route.islamic38sat.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.route.islamic38sat.R
import com.route.islamic38sat.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startHomeActivity()
    }

    private fun startHomeActivity() {
        Handler(Looper.getMainLooper())
            .postDelayed({
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }, 2000)
    }

}