package com.bitcodetech.findroomies.posts.models

data class Post(
    val name : String,
    val address : String,
    val rent : Float,
    val imageUrl : String?
)
