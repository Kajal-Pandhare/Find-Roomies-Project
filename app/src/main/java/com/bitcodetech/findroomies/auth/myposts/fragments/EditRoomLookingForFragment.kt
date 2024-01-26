package com.bitcodetech.findroomies.auth.myposts.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.auth.addposts.fragments.AddImageFragment
import com.bitcodetech.findroomies.auth.addposts.model.AddPostModel
import com.bitcodetech.findroomies.auth.myposts.models.EditMyPost
import com.bitcodetech.findroomies.databinding.EditRoomLookingForFragmentBinding

class EditRoomLookingForFragment : Fragment() {
    private lateinit var binding : EditRoomLookingForFragmentBinding
    private var myPost : EditMyPost? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EditRoomLookingForFragmentBinding.inflate(layoutInflater)

        editRoomDetails()
        initListener()
       return binding.root
    }
    private fun editRoomDetails(){
        if(arguments != null){
            myPost = requireArguments().getSerializable("editMyPost") as EditMyPost

            binding.edtMinAge.setText(myPost?.minAge.toString() ?: "")
            binding.edtMaxAge.setText(myPost?.maxAge.toString() ?: "")
            binding.edtGenderPreference.setText(myPost?.genderPreference.toString() ?: "")
            binding.edtOccupation.setText(myPost?.occupation.toString() ?: "")
            binding.edtNoOfRoommatesRequired.setText(myPost?.noOfRoommatesRequired.toString() ?: "")
        }

    }

    private fun initListener(){
        binding.btnNext.setOnClickListener {

            val minAge = binding.edtMinAge.text.toString()
            val maxAge = binding.edtMaxAge.text.toString()
            val genderPreference = binding.edtGenderPreference.text.toString()
            val occupation = binding.edtOccupation.text.toString()
            val noOfRoommatesRequired = binding.edtNoOfRoommatesRequired.text.toString()

            val editMyPost  : AddPostModel = arguments?.getSerializable("addPostModel")as? AddPostModel
                ?: AddPostModel(
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
            bundle.putSerializable("addPostModel",editMyPost)

            val editImageFragment = EditImageFragment()
            //addImageFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .add(R.id.mainContainer,editImageFragment,null)
                .addToBackStack(null)
                .commit()
        }
    }
}