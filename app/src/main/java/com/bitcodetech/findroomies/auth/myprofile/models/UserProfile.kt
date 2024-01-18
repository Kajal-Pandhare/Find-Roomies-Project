package com.bitcodetech.findroomies.auth.myprofile.models

import java.io.Serializable

data class UserProfile(
    val userProfileImage : String,
    val userName : String,
    val contactNo : Int,
    val whatsappNo : Int,
    val dob : String
):Serializable
