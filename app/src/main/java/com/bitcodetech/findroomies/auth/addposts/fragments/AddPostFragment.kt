package com.bitcodetech.findroomies.auth.addposts.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.auth.addposts.model.AddPostModel
import com.bitcodetech.findroomies.auth.addposts.viewmodels.AddPostViewModel
import com.bitcodetech.findroomies.databinding.AddPostsFragmentBinding

class AddPostFragment : Fragment() {
    private lateinit var binding : AddPostsFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AddPostsFragmentBinding.inflate(layoutInflater)

        initViewListeners()
        
        return binding.root
    }
    private fun initViewListeners(){

        binding.btnNext.setOnClickListener {
//            addPostModel.add(AddPostModel(
                val address =  binding.edtAddress.text.toString()
                val state =  binding.edtState.text.toString()
                val country = binding.edtCountry.text.toString()
                val pincode =  binding.edtPincode.text.toString()
                val latitude = binding.edtLatitude.text.toString()
                val longitude = binding.edtLongitude.text.toString()
                val deposit = binding.edtDeposite.text.toString()
                val rent = binding.edtRent.text.toString()
                val availableFrom = binding.edtAvailableFrom.text.toString()
                val noOfCurrentRoommates = binding.edtNoOfCurrentRoommates.text.toString()
                val noOfCurrentFemaleRoommates = binding.edtNoOfCurrentFemaleRoommates.text.toString()
                val noOfCurrentMaleRoommates = binding.edtNoOfCurrentMaleRoommates.text.toString()
                val isFurnished=  binding.edtIsFurnished.text.toString()

            val addPostModel = AddPostModel(
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
            bundle.putSerializable("addPostModel",addPostModel)

            val roomLookingForFragment = RoomLookingForFragment()
            roomLookingForFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .add(R.id.mainContainer,roomLookingForFragment,null)
                .addToBackStack(null)
                .commit()
        }
    }

}