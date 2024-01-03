package com.bitcodetech.findroomies.posts.repository

import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.posts.models.Posts

class PostsRepository {

    val posts = ArrayList<Posts>()
    fun addPosts(){
        posts.add(Posts(
            R.mipmap.ic_launcher,
            "kajal",
            "ganeshnagar",
            4000
        ))
    }
}