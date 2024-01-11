package com.bitcodetech.findroomies.auth.addposts.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitcodetech.findroomies.auth.addposts.model.AddPost
import com.bitcodetech.findroomies.auth.addposts.repository.AddPostRepository
import com.bitcodetech.findroomies.auth.posts.models.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddPostViewModel(private val addPostRepository: AddPostRepository
) : ViewModel() {
    val addPostMutableLiveData = MutableLiveData<Boolean>()

    fun addPost(
        postImage :Int,
        address : String,
        state : String,
        country : String,
        pincode : Int,
        latitude : Int,
        longitude : Int,
        deposite : Int,
        rent : Int,
        availableFrom : String,
        noOfCurrentRoommates : Int,
        noOfCurrentFemaleRoommates : Int,
        noOfCurrentMaleRoommates : Int,
        isFurnished : String,
        minAge : Int,
        maxAge : Int,
        genderPreference : String,
        occupation : String,
        noOfRoommatesRequired : Int

    ){
        CoroutineScope(Dispatchers.IO).launch {
            val response = addPostRepository.addPost(
                AddPost(
                postImage,
                    address,
                    state,
                    country,
                    pincode,
                    latitude,
                    longitude,
                    deposite,
                    rent,
                    availableFrom,
                    noOfCurrentRoommates,
                    noOfCurrentFemaleRoommates,
                    noOfCurrentMaleRoommates,
                    isFurnished,
                    minAge,
                    maxAge,
                    genderPreference,
                    occupation,
                    noOfRoommatesRequired
            )
            )
            withContext(Dispatchers.Main){
                addPostMutableLiveData.postValue(response)
            }
        }
    }
}