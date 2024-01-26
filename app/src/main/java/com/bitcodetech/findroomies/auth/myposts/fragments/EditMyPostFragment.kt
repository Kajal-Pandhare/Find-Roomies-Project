package com.bitcodetech.findroomies.auth.myposts.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.auth.addposts.model.AddPostModel
import com.bitcodetech.findroomies.auth.myposts.models.EditMyPost
import com.bitcodetech.findroomies.auth.myprofile.models.UserProfile
import com.bitcodetech.findroomies.databinding.EditMyPostsFragmentBinding
import com.bitcodetech.findroomies.databinding.EditProfileFragmentBinding
import com.bitcodetech.findroomies.databinding.EditRoomLookingForFragmentBinding

class EditMyPostFragment : Fragment() {
    private lateinit var binding: EditMyPostsFragmentBinding
    private var myPost : EditMyPost? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EditMyPostsFragmentBinding.inflate(layoutInflater)

        editMyPost()
        initListener()
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }

    private fun editMyPost(){
        if(arguments != null){
            myPost = requireArguments().getSerializable("editMyPost") as EditMyPost

            binding.edtAddress.setText(myPost?.address.toString() ?: "")
            binding.edtState.setText(myPost?.state.toString() ?: "")
            binding.edtCountry.setText(myPost?.country.toString() ?: "")
            binding.edtPincode.setText(myPost?.pincode.toString() ?: "")
            binding.edtLatitude.setText(myPost?.latitude.toString() ?: "")
            binding.edtLongitude.setText(myPost?.longitude.toString() ?: "")
            binding.edtDeposite.setText(myPost?.deposite.toString() ?: "")
            binding.edtRent.setText(myPost?.rent.toString() ?: "")
            binding.edtAvailableFrom.setText(myPost?.availableFrom.toString() ?: "")
            binding.edtNoOfCurrentRoommates.setText(myPost?.noOfCurrentRoommates.toString() ?: "")
            binding.edtNoOfCurrentFemaleRoommates.setText(myPost?.noOfCurrentFemaleRoommates.toString() ?: "")
            binding.edtNoOfCurrentMaleRoommates.setText(myPost?.noOfCurrentMaleRoommates.toString() ?: "")
            binding.edtIsFurnished.setText(myPost?.isFurnished.toString() ?: "")
        }

    }
    private fun initListener() {
        binding.btnNext.setOnClickListener {
//            addPostModel.add(AddPostModel(
            val address = binding.edtAddress.text.toString()
            val state = binding.edtState.text.toString()
            val country = binding.edtCountry.text.toString()
            val pincode = binding.edtPincode.text.toString()
            val latitude = binding.edtLatitude.text.toString()
            val longitude = binding.edtLongitude.text.toString()
            val deposit = binding.edtDeposite.text.toString()
            val rent = binding.edtRent.text.toString()
            val availableFrom = binding.edtAvailableFrom.text.toString()
            val noOfCurrentRoommates= binding.edtNoOfCurrentRoommates.text.toString()
            val noOfCurrentFemaleRoommates = binding.edtNoOfCurrentFemaleRoommates.text.toString()
            val noOfCurrentMaleRoommates = binding.edtNoOfCurrentMaleRoommates.text.toString()
            val isFurnished = binding.edtIsFurnished.text.toString()

            val editMyPost = EditMyPost(
                address,
                state,
                country,
                pincode,
                latitude,
                longitude,
                deposit,
                rent,
                availableFrom,
                noOfCurrentRoommates,
                noOfCurrentFemaleRoommates,
                noOfCurrentMaleRoommates,
                isFurnished,
                "",
                "",
                "",
                "",
                "",
                ""
            )

            val bundle = Bundle()
            bundle.putSerializable("addPostModel", editMyPost)

                val editRoomLookingForFragment = EditRoomLookingForFragment()

                parentFragmentManager.beginTransaction()
                    .add(R.id.mainContainer, editRoomLookingForFragment, null)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
