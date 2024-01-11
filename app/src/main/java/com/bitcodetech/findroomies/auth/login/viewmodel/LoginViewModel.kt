package com.bitcodetech.findroomies.auth.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitcodetech.findroomies.auth.login.models.Credentials
import com.bitcodetech.findroomies.auth.login.repository.LoginRepository
import com.bitcodetech.findroomies.commons.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(
    private val loginRepository: LoginRepository
) : ViewModel() {

    val userLoginStatusLiveData = MutableLiveData<Boolean>()

    fun validateCredentials(
        username : String,
        password : String
    ){
        CoroutineScope(Dispatchers.IO).launch {
             val response = loginRepository.validateCredentials(
                 Credentials(username, password)
             )

            withContext(Dispatchers.Main){
                userLoginStatusLiveData.postValue(response)
            }
        }
    }

}