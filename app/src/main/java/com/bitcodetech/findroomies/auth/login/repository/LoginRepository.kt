package com.bitcodetech.findroomies.auth.login.repository

import com.bitcodetech.findroomies.auth.login.models.Credentials
import com.bitcodetech.findroomies.auth.login.models.LoginResponse
import com.bitcodetech.findroomies.auth.login.network.LoginApiService
import com.bitcodetech.findroomies.commons.repository.Repository

class LoginRepository(private val loginApiService: LoginApiService
) : Repository() {
    suspend fun login(credentials: Credentials) : LoginResponse {
        return loginApiService.login(credentials)
    }

}