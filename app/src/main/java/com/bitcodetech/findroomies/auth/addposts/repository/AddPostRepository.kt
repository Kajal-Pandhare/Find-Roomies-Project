package com.bitcodetech.findroomies.auth.addposts.repository

import com.bitcodetech.findroomies.auth.addposts.model.AddPost
import com.bitcodetech.findroomies.auth.posts.models.Post
import com.bitcodetech.findroomies.commons.repository.Repository


class AddPostRepository : Repository() {
    fun addPost(
        post : Post
    ):Boolean{
        return true
    }
}