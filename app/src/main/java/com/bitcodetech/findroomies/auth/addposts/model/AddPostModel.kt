package com.bitcodetech.findroomies.auth.addposts.model

import java.io.Serializable

data class AddPostModel(
       val address: String,
       val state: String,
       val country: String,
       val pincode: String,
       val latitude: String,
       val longitude: String,
       val deposite: String,
       val rent: String,
       val availableFrom: String,
       val noOfCurrentRoommates: String,
       val noOfCurrentFemaleRoommates: String,
       val noOfCurrentMaleRoommates: String,
       val isFurnished: String,
       val minAge: String,
       val maxAge: String,
       val genderPreference: String,
       val occupation: String,
       val noOfRoommatesRequired: String,
       val postImage: String
 ):Serializable /*{

     var postImage: Int= 0
     var address: String = ""
     var state: String = ""
     var country: String = ""
     var pincode: Int = 0
     var latitude: Int = 0
     var longitude: Int = 0
     var deposite: Int = 0
     var rent: Int = 0
     var availableFrom: String = ""
     var noOfCurrentRoommates: Int = 0
     var noOfCurrentFemaleRoommates: Int = 0
     var noOfCurrentMaleRoommates: Int = 0
     var isFurnished: String = ""
     var minAge: Int = 0
     var maxAge: Int = 0
     var genderPreference: String = ""
     var occupation: String = ""
     var noOfRoommatesRequired: Int = 0
 }*/