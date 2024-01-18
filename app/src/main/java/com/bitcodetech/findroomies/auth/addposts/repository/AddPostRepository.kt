package com.bitcodetech.findroomies.auth.addposts.repository

import com.bitcodetech.findroomies.auth.addposts.model.AddPostModel
import com.bitcodetech.findroomies.commons.repository.Repository


class AddPostRepository : Repository() {
    fun addPost(
        post : AddPostModel
    ):Boolean{
        return true
    }
}