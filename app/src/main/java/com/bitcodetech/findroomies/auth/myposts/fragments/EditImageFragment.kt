package com.bitcodetech.findroomies.auth.myposts.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.auth.addposts.repository.AddPostRepository
import com.bitcodetech.findroomies.auth.addposts.viewmodels.AddPostViewModel
import com.bitcodetech.findroomies.auth.myposts.repository.MyPostRepository
import com.bitcodetech.findroomies.auth.myposts.viewmodel.MyPostViewModel
import com.bitcodetech.findroomies.auth.posts.fragment.PostsFragment
import com.bitcodetech.findroomies.commons.factory.ViewModelFactory
import com.bitcodetech.findroomies.databinding.EditImageFragmentBinding

class EditImageFragment  : Fragment() {
    private lateinit var binding : EditImageFragmentBinding
    private lateinit var myPostViewModel: MyPostViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EditImageFragmentBinding.inflate(layoutInflater)

        initListener()
        initViewModels()
        initObserver()
        binding.root.setOnClickListener {  }
        return binding.root
    }
    private fun initListener(){
        binding.btnAddPost.setOnClickListener {
            val myPostFragment = MyPostFragment()

            parentFragmentManager.beginTransaction()
                .add(R.id.mainContainer,myPostFragment,null)
                .addToBackStack(null)
                .commit()
        }

    }
    private fun initObserver()
    {
        myPostViewModel.myPostsMutableLiveData.observe(
            viewLifecycleOwner
        ){
            parentFragmentManager.popBackStack()
        }
    }    private fun initViewModels(){
        myPostViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                MyPostRepository()
            )
        )[MyPostViewModel::class.java]
    }

}