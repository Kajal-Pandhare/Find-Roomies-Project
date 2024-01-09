package com.bitcodetech.findroomies.auth.addposts.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
        postImage: Int,
        name: String,
        address: String,
        rent: Int
    ){
        CoroutineScope(Dispatchers.IO).launch {
            val response = addPostRepository.addPost(
                Post(
                postImage,
                name,
                address,
                rent
            )
            )
            withContext(Dispatchers.Main){
                addPostMutableLiveData.postValue(response)
            }
        }
    }
}