package com.bitcodetech.findroomies.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.findroomies.auth.repository.LoginRepository
import com.bitcodetech.findroomies.auth.viewmodel.LoginViewModel
import java.lang.Exception

class ViewModelFactory(
    private val loginRepository: LoginRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(loginRepository) as T
        }

        throw Exception("Unable to create view model...")
    }
}