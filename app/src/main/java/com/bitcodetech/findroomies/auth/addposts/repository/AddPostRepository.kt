package com.bitcodetech.findroomies.auth.addposts.repository

import com.bitcodetech.findroomies.auth.addposts.model.AddPost
import com.bitcodetech.findroomies.commons.repository.Repository
import com.bitcodetech.findroomies.posts.models.Post

class AddPostRepository : Repository() {
    fun addPost(
        post : Post
    ):Boolean{
        return true
    }
}