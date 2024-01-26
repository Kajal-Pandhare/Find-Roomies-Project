package com.bitcodetech.findroomies.auth.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitcodetech.findroomies.auth.login.models.Credentials
import com.bitcodetech.findroomies.auth.login.repository.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(
    private val loginRepository: LoginRepository
) : ViewModel() {

    /*val userLoginStatusLiveData = MutableLiveData<Boolean>()
    //val credentials = ArrayList<Credentials>()
    fun validateCredentials(username : String, password : String) {
        CoroutineScope(Dispatchers.IO).launch {
             val credentials = loginRepository.login(
                 Credentials(username, password)
             )

            withContext(Dispatchers.Main){
                //this@LoginViewModel.credentials.addAll(credentials)
                userLoginStatusLiveData.postValue(true)
            }
        }
    }*/
    val loginUpdateAvailableLiveData =MutableLiveData<Boolean>()

    fun validateCredentials(
        username : String,
        password : String
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = loginRepository.validateCredentials(
                Credentials(username, password)
            )

            withContext(Dispatchers.Main) {
                loginUpdateAvailableLiveData.postValue(response)
            }
        }
    }
}