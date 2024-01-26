package com.bitcodetech.findroomies.auth.login.models

import com.bitcodetech.findroomies.auth.register.models.UserRegistration
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    val credentials : ArrayList<Credentials>
)
