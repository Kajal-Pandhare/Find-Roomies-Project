package com.bitcodetech.findroomies.auth.register.models

data class UserRegistration(
    val username : String,
    val email : String,
    val password : String,
    val gender  : Int,
    val confirmPassword  : String,
    val mobile_no : Int,
    val whatsapp_no  : Int,
    val dob  :String
)
