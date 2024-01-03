package com.bitcodetech.findroomies.posts.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitcodetech.findroomies.databinding.PostsFragmentBinding

class PostsFragment : Fragment() {
private lateinit var binding : PostsFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PostsFragmentBinding.inflate(layoutInflater)

        return binding.root
    }
}