package com.bitcodetech.findroomies.auth.register.repository

import com.bitcodetech.findroomies.auth.register.models.RegisterResponse
import com.bitcodetech.findroomies.auth.register.models.UserPostModel
import com.bitcodetech.findroomies.auth.register.network.RegisterApiService
import com.bitcodetech.findroomies.commons.repository.Repository

class RegistrationRepository(
    private val registerApiService: RegisterApiService
)  : Repository() {

    suspend fun addUser(
        userPostModel: UserPostModel
    ) : RegisterResponse {
        return registerApiService.addUser(userPostModel)
    }
}