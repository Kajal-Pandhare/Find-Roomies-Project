package com.bitcodetech.findroomies.posts.repository

import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.commons.repository.Repository
import com.bitcodetech.findroomies.posts.models.Post

class PostsRepository : Repository() {

    fun fetchPosts() : List<Post> {

        val posts = ArrayList<Post>()

        posts.add(Post(
            R.drawable.room1,
            "kajal",
            "Satyam Industrial Estate, Aasmant Apts, Sr.No.1/4, Near, Opp. SNDT College, Pune, Maharashtra 411004, India",
            4000
        ))
        posts.add(Post(
            R.drawable.room2,
            "Bhagwan",
            "595, Budhwar Peth Rd, Budhwar Peth, Pune, Maharashtra 411002, India",
            6000
        ))
        posts.add(Post(
            R.drawable.room3,
            "Anirudh",
            "Plot 21, Kripa Bungalow,, Sr No 25, Kshipra Society, Lane Number 2, Karve Nagar, Pune, Maharashtra 411052, India",
            8000
        ))
        posts.add(Post(
            R.drawable.room4,
            "Akshay",
            "3rd Floor, Borate Sankul,Opp Yashwantrao Chavan Natyagruha, Kothrud, Pune, Maharashtra 411038, India",
            10000
        ))
        return posts
    }
}