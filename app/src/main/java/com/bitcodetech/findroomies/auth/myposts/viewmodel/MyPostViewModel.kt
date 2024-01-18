package com.bitcodetech.findroomies.auth.myposts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitcodetech.findroomies.auth.myposts.models.MyPost
import com.bitcodetech.findroomies.auth.myposts.repository.MyPostRepository
import com.bitcodetech.findroomies.auth.posts.models.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyPostViewModel(private val myPostRepository: MyPostRepository)  :ViewModel() {
    val postsMutableLiveData = MutableLiveData<Boolean>()
    val myPost = ArrayList<MyPost>()

    fun fetchPosts() {
        CoroutineScope(Dispatchers.IO).launch {
            val myPost = myPostRepository.fetchPosts()

            withContext(Dispatchers.Main) {
                this@MyPostViewModel.myPost.addAll(myPost)
                postsMutableLiveData.postValue(true)
            }
        }
    }
}