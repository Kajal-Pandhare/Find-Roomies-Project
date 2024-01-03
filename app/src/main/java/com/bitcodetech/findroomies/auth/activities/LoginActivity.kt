package com.bitcodetech.findroomies.auth.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.findroomies.MainActivity
import com.bitcodetech.findroomies.commons.factory.ViewModelFactory
import com.bitcodetech.findroomies.auth.repository.LoginRepository
import com.bitcodetech.findroomies.auth.viewmodel.LoginViewModel
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
    }
    private fun initViews(){
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}