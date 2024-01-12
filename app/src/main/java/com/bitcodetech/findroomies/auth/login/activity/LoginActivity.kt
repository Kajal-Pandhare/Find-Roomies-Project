package com.bitcodetech.findroomies.auth.login.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.findroomies.MainActivity
import com.bitcodetech.findroomies.auth.login.repository.LoginRepository
import com.bitcodetech.findroomies.auth.login.viewmodel.LoginViewModel
import com.bitcodetech.findroomies.auth.register.activity.ResisterActivity
import com.bitcodetech.findroomies.commons.factory.ViewModelFactory
import com.bitcodetech.findroomies.databinding.LoginActivityBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: LoginActivityBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        initListener()
        initViewModels()
        initObserver()
    }
    private fun initObserver(){
        loginViewModel.userLoginStatusLiveData.observe(
            this
        ){
            if(it) {
                finish()
                startMainActivity()
            }
            else {

            }
        }
    }

    private fun startMainActivity() {
        startActivity(
            Intent(this@LoginActivity, MainActivity::class.java)
        )
    }

    private fun initViewModels(){
        loginViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                LoginRepository()
            )
        )[LoginViewModel::class.java]
    }
    private fun initListener(){
        binding.btnLogin.setOnClickListener {
            loginViewModel.validateCredentials(
                binding.edtUserName.text.toString(),
                binding.edtPassword.text.toString()
            )
        }
        binding.txtRegister.setOnClickListener {
            val intent = Intent(this@LoginActivity,ResisterActivity::class.java)
            startActivity(intent)
            //Toast.makeText(this,"text clicked",Toast.LENGTH_SHORT).show()


        }
    }
    private fun initViews(){
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}