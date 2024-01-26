package com.bitcodetech.findroomies.auth.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.auth.posts.fragment.PostsFragment
import com.bitcodetech.findroomies.databinding.AboutProjectFragmentBinding

class AboutProjectFragment : Fragment() {
    private lateinit var binding: AboutProjectFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AboutProjectFragmentBinding.inflate(layoutInflater)

        setHasOptionsMenu(true)
        initListener()
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun initListener() {
        binding.btnDone.setOnClickListener {
            val postsFragment = PostsFragment()

            parentFragmentManager.beginTransaction()
                .add(R.id.mainContainer, postsFragment, null)
                .addToBackStack(null)
                .commit()
        }
    }
}