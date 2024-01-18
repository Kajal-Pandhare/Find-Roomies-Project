package com.bitcodetech.findroomies.auth.myposts.repository

import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.auth.myposts.models.MyPost
import com.bitcodetech.findroomies.auth.posts.models.Post
import com.bitcodetech.findroomies.commons.repository.Repository

class MyPostRepository : Repository() {

    fun fetchPosts() : List<MyPost> {

        val myPost = ArrayList<MyPost>()

        myPost.add(
           MyPost(
            R.drawable.room1,
            "kajal",
            "Satyam Industrial Estate, Aasmant Apts, Sr.No.1/4, Near, Opp. SNDT College, Pune, Maharashtra 411004, India",
            4000
        )
        )
        myPost.add(
            MyPost(
            R.drawable.room2,
            "Bhagwan",
            "595, Budhwar Peth Rd, Budhwar Peth, Pune, Maharashtra 411002, India",
            6000
        )
        )
        return myPost
    }
}