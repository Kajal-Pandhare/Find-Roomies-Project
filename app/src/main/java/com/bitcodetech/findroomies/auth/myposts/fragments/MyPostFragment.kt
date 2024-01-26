package com.bitcodetech.findroomies.auth.myposts.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.auth.about.AboutProjectFragment
import com.bitcodetech.findroomies.auth.addposts.fragments.AddPostFragment
import com.bitcodetech.findroomies.auth.details.fragments.DetailsFragment
import com.bitcodetech.findroomies.auth.myposts.adapter.MyPostAdapter
import com.bitcodetech.findroomies.auth.myposts.models.MyPost
import com.bitcodetech.findroomies.auth.myposts.repository.MyPostRepository
import com.bitcodetech.findroomies.auth.myposts.viewmodel.MyPostViewModel
import com.bitcodetech.findroomies.auth.myprofile.fragments.EditProfileFragment
import com.bitcodetech.findroomies.auth.myprofile.fragments.ProfileFragment
import com.bitcodetech.findroomies.auth.posts.adapter.PostsAdapter
import com.bitcodetech.findroomies.auth.posts.models.Post
import com.bitcodetech.findroomies.auth.posts.repository.PostsRepository
import com.bitcodetech.findroomies.auth.posts.viewmodel.PostsViewModel
import com.bitcodetech.findroomies.commons.factory.ViewModelFactory
import com.bitcodetech.findroomies.databinding.MyPostFragmentBinding

class MyPostFragment : Fragment() {
private lateinit var binding : MyPostFragmentBinding
private lateinit var myPostViewModel : MyPostViewModel
private lateinit var myPostAdapter : MyPostAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MyPostFragmentBinding.inflate(layoutInflater)

        initViews()
        initViewModels()
        initAdapter()
        initObserver()
        initListeners()

        myPostViewModel.fetchPosts()
        setHasOptionsMenu(true)
        binding.root.setOnClickListener {  }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }
    private fun initListeners() {
        binding.recyclerMyPost.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                        myPostViewModel.fetchPosts()
                    }
                }
            })

        myPostAdapter.onMyPostClickListener =
            object : MyPostAdapter.OnMyPostClickListener {
                override fun onMyPostListener(
                    myPost: MyPost,
                    position: Int,
                    myPostAdapter: MyPostAdapter
                ) {
                    showDetailsFragment(myPost)
                    // Log.e("tag","event deligationn model work")
                }
            }

    }


    private fun showDetailsFragment(myPost: MyPost) {
        val showDetailsFragment = ShowDetailsFragment()

        //val input = Bundle()
        parentFragmentManager.beginTransaction()
            .add(R.id.mainContainer, showDetailsFragment, null)
            .addToBackStack(null)
            .commit()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initObserver() {
        myPostViewModel.myPostsMutableLiveData.observe(
            viewLifecycleOwner
        ) {
            if (it) {
                myPostAdapter.notifyDataSetChanged()
            }
        }
    }


    private fun initAdapter() {
        myPostAdapter = MyPostAdapter(myPostViewModel.myPost)
        binding.recyclerMyPost.adapter = myPostAdapter
    }

    private fun initViewModels() {
        myPostViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                MyPostRepository()
            )
        )[MyPostViewModel::class.java]
    }

    private fun initViews() {
        binding.recyclerMyPost.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }
}