package com.bitcodetech.findroomies.posts.repository

import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.commons.repository.Repository
import com.bitcodetech.findroomies.posts.models.Post

class PostsRepository : Repository() {

    fun fetchPosts() : List<Post> {

        val posts = ArrayList<Post>()

        posts.add(Post(
            "kajal",
            "ganeshnagar",
            4000F,
            "https://bitcode.in/images/getfirstjob/get_first_job_as_fresher_pune_bitcode.jpg"
        ))
        posts.add(Post(
            "kajal",
            "ganeshnagar",
            4000F,
            "https://bitcode.in/images/getfirstjob/get_first_job_as_fresher_pune_bitcode.jpg"
        ))
        posts.add(Post(
            "kajal",
            "ganeshnagar",
            4000F,
            "https://bitcode.in/images/getfirstjob/get_first_job_as_fresher_pune_bitcode.jpg"
        ))
        posts.add(Post(
            "kajal",
            "ganeshnagar",
            4000F,
            "https://bitcode.in/images/getfirstjob/get_first_job_as_fresher_pune_bitcode.jpg"
        ))
        return posts
    }
}