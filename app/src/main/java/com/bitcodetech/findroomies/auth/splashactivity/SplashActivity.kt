package com.bitcodetech.findroomies.auth.splashactivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bitcodetech.findroomies.auth.login.activity.LoginActivity
import com.bitcodetech.findroomies.databinding.SplashActivityBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding : SplashActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            val intent = Intent(this@SplashActivity,LoginActivity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}