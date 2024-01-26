package com.bitcodetech.findroomies.auth.ownerdetails.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.auth.ownerdetails.repository.OwnerDetailsRepository
import com.bitcodetech.findroomies.auth.ownerdetails.viewmodel.OwnerDetailsViewModel
import com.bitcodetech.findroomies.auth.posts.fragment.PostsFragment
import com.bitcodetech.findroomies.commons.factory.ViewModelFactory
import com.bitcodetech.findroomies.databinding.OwnerDetailsFragmentBinding

class OwnerDetailsFragment : Fragment() {
private lateinit var binding : OwnerDetailsFragmentBinding
private lateinit var ownerDetailsViewModel: OwnerDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OwnerDetailsFragmentBinding.inflate(layoutInflater)

        initViewModel()
        initObserver()
        initListeners()
        return binding.root
    }
    @SuppressLint("CommitTransaction")
    private fun initListeners(){
        binding.btnDone.setOnClickListener {
             var postsFragment = PostsFragment()

            parentFragmentManager.beginTransaction()
                .add(R.id.mainContainer,postsFragment,null)
                .addToBackStack(null)
                .commit()

        }
    }
    private fun initObserver(){
        ownerDetailsViewModel.ownerDetailsMutableLiveData.observe(
            viewLifecycleOwner
        ){
            if (it){
                parentFragmentManager.popBackStack()
            }
        }
    }
    private fun initViewModel(){
        ownerDetailsViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                OwnerDetailsRepository()
            )
        )[OwnerDetailsViewModel::class.java]
    }
}