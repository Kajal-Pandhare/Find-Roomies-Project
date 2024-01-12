package com.bitcodetech.findroomies.auth.posts.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.auth.addposts.fragments.AddPostsFragment
import com.bitcodetech.findroomies.auth.details.fragments.DetailsFragment
import com.bitcodetech.findroomies.auth.posts.adapter.PostsAdapter
import com.bitcodetech.findroomies.auth.posts.models.Post
import com.bitcodetech.findroomies.auth.posts.repository.PostsRepository
import com.bitcodetech.findroomies.auth.posts.viewmodel.PostsViewModel
import com.bitcodetech.findroomies.databinding.PostsFragmentBinding
import com.bitcodetech.findroomies.commons.factory.ViewModelFactory

class PostsFragment : Fragment() {
private lateinit var binding : PostsFragmentBinding
private lateinit var postsViewModel: PostsViewModel
private lateinit var postsAdapter: PostsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PostsFragmentBinding.inflate(layoutInflater)

        initViews()
        initViewModels()
        initAdapter()
        initObserver()
        initListeners()

        postsViewModel.fetchPosts()
        return binding.root
    }
    private fun initListeners() {
        binding.recyclerPosts.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                        postsViewModel.fetchPosts()
                    }
                }
            })
        binding.btnAddPosts.setOnClickListener {
            addPostsFragment()
        }
        postsAdapter.onPostClickListener =
            object  : PostsAdapter.OnPostClickListener
            {
                override fun onPostListener(post: Post,
                                            position: Int,
                                            postsAdapter: PostsAdapter) {
                    showDetailsFragment(post)
                  // Log.e("tag","event deligationn model work")
                }
            }
    }
    private fun showDetailsFragment(post: Post) {
            val detailsFragment = DetailsFragment()

        //val input = Bundle()
        parentFragmentManager.beginTransaction()
            .add(R.id.mainContainer,detailsFragment,null)
            .addToBackStack(null)
            .commit()
    }


    private fun addPostsFragment(){
        val addPostsFragment = AddPostsFragment()
        parentFragmentManager.beginTransaction()
            .add(R.id.mainContainer,addPostsFragment,null)
            .addToBackStack(null)
            .commit()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initObserver(){
        postsViewModel.postsMutableLiveData.observe(
            viewLifecycleOwner
        ){
            if (it){
                postsAdapter.notifyDataSetChanged()
            }
        }
    }
    private fun initAdapter(){
        postsAdapter = PostsAdapter(postsViewModel.posts)
        binding.recyclerPosts.adapter = postsAdapter
    }
    private fun initViewModels(){
        postsViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                PostsRepository()
            )
        )[PostsViewModel::class.java]
    }
    private fun initViews(){
        binding.recyclerPosts.layoutManager =
            LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }
}