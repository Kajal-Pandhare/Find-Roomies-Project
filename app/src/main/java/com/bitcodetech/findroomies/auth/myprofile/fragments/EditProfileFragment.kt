package com.bitcodetech.findroomies.auth.myprofile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.auth.myposts.fragments.MyPostFragment
import com.bitcodetech.findroomies.auth.myprofile.models.UserProfile
import com.bitcodetech.findroomies.auth.posts.fragment.PostsFragment
import com.bitcodetech.findroomies.databinding.EditProfileFragmentBinding

class EditProfileFragment  : Fragment() {
    private lateinit var binding  : EditProfileFragmentBinding
    private var userProfile : UserProfile? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EditProfileFragmentBinding.inflate(layoutInflater)
        editProfile()
        initListener()
        binding.root.setOnClickListener {
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }

    private fun editProfile(){
        if(arguments != null){
            userProfile = requireArguments().getSerializable("profile") as UserProfile

            binding.edtName.setText(userProfile?.userName ?: "")
            binding.edtMobileNo.setText(userProfile?.contactNo.toString() ?: "")
            binding.edtWhatsappNo.setText(userProfile?.whatsappNo.toString() ?: "")
            binding.edtDob.setText(userProfile?.dob ?: "")
        }

    }
    private fun initListener(){

        binding.btnUpdateProfile.setOnClickListener {
            Toast.makeText(context,"Profile Updated",Toast.LENGTH_SHORT).show()

            val myProfileFragment = ProfileFragment()
            parentFragmentManager.beginTransaction()
                .add(R.id.mainContainer, myProfileFragment, null)
                .addToBackStack(null)
                .commit()
        }
    }

}