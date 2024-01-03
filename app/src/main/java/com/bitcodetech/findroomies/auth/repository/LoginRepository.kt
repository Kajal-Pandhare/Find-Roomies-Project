package com.bitcodetech.findroomies.auth.repository

import com.bitcodetech.findroomies.auth.models.Credentials

class LoginRepository {
    fun validateCredentials(
        credentials: Credentials
    ) : Boolean {
        return true
    }
}