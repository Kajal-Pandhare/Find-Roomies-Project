package com.bitcodetech.findroomies.auth.addposts.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.auth.addposts.model.AddPostModel
import com.bitcodetech.findroomies.databinding.RoomLookingForFragmentBinding

class RoomLookingForFragment : Fragment() {
    private lateinit var binding : RoomLookingForFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RoomLookingForFragmentBinding.inflate(layoutInflater)

        initListener()
        binding.root.setOnClickListener {  }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.Gender,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinner.adapter = adapter
    }
    private fun initListener(){
        binding.btnNext.setOnClickListener {

//            roomLookingForViewModel.addRoomLookingFor(

                val minAge = binding.edtMinAge.text.toString()
                val maxAge = binding.edtMaxAge.text.toString()
                val genderPreference = binding.edtGenderPreference.text.toString()
                val occupation = binding.edtOccupation.text.toString()
                val noOfRoommatesRequired = binding.edtNoOfRoommatesRequired.text.toString()

            val addPostModel  :AddPostModel = arguments?.getSerializable("addPostModel")as?AddPostModel?: AddPostModel(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "","",
                "",
                "",
                "",
                "",
                minAge,
                maxAge,
                genderPreference,
                occupation,
                noOfRoommatesRequired,
                ""

            )
            val bundle = Bundle()
            bundle.putSerializable("addPostModel",addPostModel)

            val addImageFragment = AddImageFragment()
            addImageFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .add(R.id.mainContainer,addImageFragment,null)
                .addToBackStack(null)
                .commit()
        }
    }
    }
