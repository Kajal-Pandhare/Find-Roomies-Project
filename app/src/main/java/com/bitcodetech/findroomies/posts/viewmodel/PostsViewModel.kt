package com.bitcodetech.findroomies.posts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitcodetech.findroomies.posts.models.Post
import com.bitcodetech.findroomies.posts.repository.PostsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostsViewModel(
    private val postsRepository: PostsRepository
) : ViewModel() {

    val postsMutableLiveData = MutableLiveData<Boolean>()
    val posts = ArrayList<Post>()

    fun fetchPosts() {
        CoroutineScope(Dispatchers.IO).launch {
            val posts = postsRepository.fetchPosts()
            this@PostsViewModel.posts.addAll(posts)
            withContext(Dispatchers.Main){
                postsMutableLiveData.postValue(true)
            }
        }
    }
}