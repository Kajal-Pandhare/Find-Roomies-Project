package com.bitcodetech.findroomies.auth.addposts.model

data class AddPost(
    val postImage :Int,
    val address : String,
    val state : String,
    val country : String,
    val pincode : Int,
    val latitude : Int,
    val longitude : Int,
    val deposite : Int,
    val rent : Int,
    val availableFrom : String,
    val noOfCurrentRoommates : Int,
    val noOfCurrentFemaleRoommates : Int,
    val noOfCurrentMaleRoommates : Int,
    val isFurnished : String,
    val minAge : Int,
    val maxAge : Int,
    val genderPreference : String,
    val occupation : String,
    val noOfRoommatesRequired : Int
)