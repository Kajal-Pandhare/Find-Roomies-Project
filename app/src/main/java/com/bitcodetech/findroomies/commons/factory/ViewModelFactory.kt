package com.bitcodetech.findroomies.commons.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.findroomies.auth.addposts.repository.AddPostRepository
import com.bitcodetech.findroomies.auth.addposts.viewmodels.AddPostViewModel
import com.bitcodetech.findroomies.auth.login.repository.LoginRepository
import com.bitcodetech.findroomies.auth.login.viewmodel.LoginViewModel
import com.bitcodetech.findroomies.commons.repository.Repository
import com.bitcodetech.findroomies.posts.repository.PostsRepository
import com.bitcodetech.findroomies.posts.viewmodel.PostsViewModel
import java.lang.Exception

class ViewModelFactory(
    private val repository: Repository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(LoginViewModel::class.java) && repository is LoginRepository) {
            return LoginViewModel(repository) as T
        }

        if(modelClass.isAssignableFrom(PostsViewModel::class.java) && repository is PostsRepository) {
            return PostsViewModel(repository) as T
        }
        if(modelClass.isAssignableFrom(AddPostViewModel::class.java) && repository is AddPostRepository) {
            return AddPostViewModel(repository) as T
        }
        throw Exception("Unable to create view model...")
    }
}