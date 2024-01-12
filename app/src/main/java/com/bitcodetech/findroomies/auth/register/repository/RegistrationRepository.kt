package com.bitcodetech.findroomies.auth.register.repository

import com.bitcodetech.findroomies.auth.register.models.UserRegistration
import com.bitcodetech.findroomies.commons.repository.Repository

class RegistrationRepository  : Repository() {

    fun postUserRegistration(
        userRegistration: UserRegistration
    ):Boolean{
        return true
    }
}