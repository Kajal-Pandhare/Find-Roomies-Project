package com.bitcodetech.findroomies.posts.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bitcodetech.findroomies.databinding.PostsFragmentBinding
import com.bitcodetech.findroomies.commons.factory.ViewModelFactory
import com.bitcodetech.findroomies.posts.adapter.PostsAdapter
import com.bitcodetech.findroomies.posts.repository.PostsRepository
import com.bitcodetech.findroomies.posts.viewmodel.PostsViewModel

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

        postsViewModel.fetchPosts()
        return binding.root
    }
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