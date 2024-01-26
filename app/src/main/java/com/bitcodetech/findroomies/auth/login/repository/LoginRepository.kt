package com.bitcodetech.findroomies.auth.login.repository

import com.bitcodetech.findroomies.auth.login.models.Credentials
import com.bitcodetech.findroomies.auth.login.models.LoginResponse
import com.bitcodetech.findroomies.auth.login.network.LoginApiService
import com.bitcodetech.findroomies.commons.repository.Repository

class LoginRepository() : Repository() {//private val loginApiService: LoginApiService
//    suspend fun login(credentials: Credentials) : LoginResponse {
//        return loginApiService.login(credentials)
//    }
fun validateCredentials(
    credentials: Credentials
) : Boolean{
    return true
}
}