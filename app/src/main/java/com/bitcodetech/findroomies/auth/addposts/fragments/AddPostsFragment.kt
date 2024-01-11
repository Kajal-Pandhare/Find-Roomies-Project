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
    ): View {
        binding = AddPostsFragmentBinding.inflate(layoutInflater)

        initViewModels()
        initObserver()
        initViewListeners()
        initImageSelectListener()
        
        return binding.root
    }
    private fun initViewListeners(){

        binding.btnAddPost.setOnClickListener {
            addPostViewModel.addPost(
                selectedImage,
                binding.edtAddress.text.toString(),
                binding.edtState.text.toString(),
                binding.edtCountry.text.toString(),
                binding.edtPincode.text.toString().toInt(),
                binding.edtLatitude.text.toString().toInt(),
                binding.edtLongitude.text.toString().toInt(),
                binding.edtDeposite.text.toString().toInt(),
                binding.edtRent.text.toString().toInt(),
                binding.edtAvailableFrom.text.toString(),
                binding.edtNoOfCurrentRoommates.text.toString().toInt(),
                binding.edtNoOfCurrentFemaleRoommates.text.toString().toInt(),
                binding.edtNoOfCurrentMaleRoommates.text.toString().toInt(),
                binding.edtIsFurnished.text.toString(),
                binding.edtMinAge.text.toString().toInt(),
                binding.edtMaxAge.text.toString().toInt(),
                binding.edtGenderPreference.text.toString(),
                binding.edtOccupation.text.toString(),
                binding.edtNoOfRoommatesRequired.text.toString().toInt(),
            )
        }
    }
    private fun initImageSelectListener() {
        binding.listingsImage1.setOnClickListener {
            selectedImage = R.drawable.room1
            binding.listingsImage1.alpha = 0.5f
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