package com.bitcodetech.findroomies.auth.login.repository

import com.bitcodetech.findroomies.auth.login.models.Credentials
import com.bitcodetech.findroomies.commons.repository.Repository

class LoginRepository : Repository() {
    fun validateCredentials(
        credentials: Credentials
    ) : Boolean {
        return true
    }
}