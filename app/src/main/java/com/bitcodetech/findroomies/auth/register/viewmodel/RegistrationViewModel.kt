package com.bitcodetech.findroomies.auth.register.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitcodetech.findroomies.auth.register.models.UserRegistration
import com.bitcodetech.findroomies.auth.register.repository.RegistrationRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegistrationViewModel(
    private val registrationRepository: RegistrationRepository
)  : ViewModel() {

    val registrationMutableLiveData = MutableLiveData<Boolean>()

    fun postUserRegistration(
        username: String,
        email: String,
        password: String,
        confirmPassword: String,
        gender: String,
        mobileNo: Int,
        whatsappNo: Int,
        date_of_birth: String
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val users = registrationRepository.postUserRegistration(
                UserRegistration(
                    username,
                    email,
                    password,
                    confirmPassword,
                    gender,
                    mobileNo,
                    whatsappNo,
                    date_of_birth
                )
            )
            withContext(Dispatchers.Main) {
                registrationMutableLiveData.postValue(users)
            }
        }
    }
}