package com.bitcodetech.findroomies.auth.addposts.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.auth.addposts.repository.AddPostRepository
import com.bitcodetech.findroomies.auth.addposts.viewmodels.AddPostViewModel
import com.bitcodetech.findroomies.commons.factory.ViewModelFactory
import com.bitcodetech.findroomies.databinding.AddPostsFragmentBinding

class AddPostsFragment : Fragment() {
    private lateinit var binding : AddPostsFragmentBinding
    private lateinit var addPostViewModel: AddPostViewModel
    private var selectedImage : Int =0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddPostsFragmentBinding.inflate(layoutInflater)

        initViewModels()
        initObserver()
        initViewListeners()
        initImageSelectListener()
        
        return binding.root
    }
    private fun initViewListeners(){

        binding.btnaddPosts.setOnClickListener {
            addPostViewModel.addPost(
                selectedImage,
                binding.edtName.text.toString(),
                binding.edtAddress.text.toString(),
                binding.edtRent.text.toString().toInt()
            )
        }
    }
    private fun initImageSelectListener() {
        binding.imagePosts.setOnClickListener {
            selectedImage = R.drawable.room1
            binding.imagePosts.alpha = 0.5f
        }
    }
    private fun initObserver()
    {
        addPostViewModel.addPostMutableLiveData.observe(
            viewLifecycleOwner
        ){
                parentFragmentManager.popBackStack()
        }
    }    private fun initViewModels(){
        addPostViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                AddPostRepository()
            )
        )[AddPostViewModel::class.java]
    }
}