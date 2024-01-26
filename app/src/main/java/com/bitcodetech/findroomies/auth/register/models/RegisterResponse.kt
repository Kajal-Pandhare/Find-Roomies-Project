package com.bitcodetech.findroomies.auth.register.models

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("data")
    val userRegistration : ArrayList<UserRegistration>
)
