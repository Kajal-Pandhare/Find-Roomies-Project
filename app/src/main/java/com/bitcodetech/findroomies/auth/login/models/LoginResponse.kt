package com.bitcodetech.findroomies.auth.login.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    val credentials : ArrayList<Credentials>
)
