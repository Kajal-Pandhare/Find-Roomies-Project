package com.bitcodetech.findroomies.auth.register.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.findroomies.MainActivity
import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.auth.login.activity.LoginActivity
import com.bitcodetech.findroomies.auth.register.repository.RegistrationRepository
import com.bitcodetech.findroomies.auth.register.viewmodel.RegistrationViewModel
import com.bitcodetech.findroomies.commons.factory.ViewModelFactory
import com.bitcodetech.findroomies.databinding.RegisterActivityBinding

class ResisterActivity  :AppCompatActivity() {

    private lateinit var binding: RegisterActivityBinding
    private lateinit var registrationViewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        initListeners()
        initModels()
        initObserver()

//        val gender = resources.getStringArray(R.array.Gender)
//
//        val spinner = binding.genderSpinner
//        if (spinner != null){
//            val adapter = ArrayAdapter(this,R.layout.register_activity,gender)
//            spinner.adapter = adapter
//        }


    }
    private fun initListeners(){
        binding.btnRegister.setOnClickListener {
            registrationViewModel.postUserRegistration(
                binding.edtName.text.toString(),
                binding.edtEmailId.text.toString(),
                binding.edtPassword.text.toString(),
                binding.edtConfirmPassword.text.toString(),
                binding.edtGender.text.toString(),
                binding.edtMobileNo.text.toString().toInt(),
                binding.edtWhatsappNo.text.toString().toInt(),
                binding.edtDob.text.toString()
            )

        }

    }
    private fun startMainActivity() {
        startActivity(
            Intent(this@ResisterActivity, LoginActivity::class.java)
        )
    }

    private fun initObserver() {
        registrationViewModel.registrationMutableLiveData.observe(
            this
        ) {
            if (it) {
                finish()
                startMainActivity()
            }
        }
    }

    private fun initModels() {
        registrationViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                RegistrationRepository()
            )
        )[RegistrationViewModel::class.java]
    }
    private fun initViews(){
        binding = RegisterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
