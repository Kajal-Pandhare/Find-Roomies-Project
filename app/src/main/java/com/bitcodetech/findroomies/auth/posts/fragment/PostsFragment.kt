package com.bitcodetech.findroomies.auth.posts.fragment

import android.annotation.SuppressLint
import android.app.SearchManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.auth.about.AboutProjectFragment
import com.bitcodetech.findroomies.auth.addposts.fragments.AddPostFragment
import com.bitcodetech.findroomies.auth.details.fragments.DetailsFragment
import com.bitcodetech.findroomies.auth.myposts.fragments.MyPostFragment
import com.bitcodetech.findroomies.auth.myprofile.fragments.ProfileFragment
import com.bitcodetech.findroomies.auth.posts.adapter.PostsAdapter
import com.bitcodetech.findroomies.auth.posts.models.Post
import com.bitcodetech.findroomies.auth.posts.repository.PostsRepository
import com.bitcodetech.findroomies.auth.posts.viewmodel.PostsViewModel
import com.bitcodetech.findroomies.databinding.PostsFragmentBinding
import com.bitcodetech.findroomies.commons.factory.ViewModelFactory
import java.util.Locale

class PostsFragment : Fragment() {
    private lateinit var binding: PostsFragmentBinding
    private lateinit var postsViewModel: PostsViewModel
    private lateinit var postsAdapter: PostsAdapter
    private var posts= ArrayList<Post>()

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
        bottomNavigation()

        setHasOptionsMenu(true)
        postsViewModel.fetchPosts()
        return binding.root

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        menu.clear()

        val searchItem = menu.findItem(R.id.searchMenu)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null){
                    binding.recyclerPosts.scrollToPosition(0)
                    postsViewModel.posts
                    searchView.clearFocus()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.searchMenu-> {
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }*/

    private fun initListeners() {
        var isHidden = false
        binding.recyclerPosts.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                        postsViewModel.fetchPosts()
                    }
                }

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if(dy> 0 && !isHidden){
                        binding.bottomNavigation.slideDown()
                        isHidden = true
                    }else if(dy < 0 && isHidden){
                        binding.bottomNavigation.slideUp()
                        isHidden = false
                    }
                }
                fun View.slideUp(){
                    this.animate().translationY(0f)
                }
                fun View.slideDown(){
                    this.animate().translationY(this.height.toFloat())
                }
            })
        binding.btnAddPosts.setOnClickListener {
            addPostsFragment()
        }
        postsAdapter.onPostClickListener =
            object : PostsAdapter.OnPostClickListener {
                override fun onPostListener(
                    post: Post,
                    position: Int,
                    postsAdapter: PostsAdapter
                ) {
                    showDetailsFragment(post)
                    // Log.e("tag","event deligationn model work")
                }
            }
    }

    private fun showDetailsFragment(post: Post) {
        val detailsFragment = DetailsFragment()

        //val input = Bundle()
        parentFragmentManager.beginTransaction()
            .add(R.id.mainContainer, detailsFragment, null)
            .addToBackStack(null)
            .commit()
    }


    private fun addPostsFragment() {
        val addPostFragment = AddPostFragment()
        parentFragmentManager.beginTransaction()
            .add(R.id.mainContainer, addPostFragment, null)
            .addToBackStack(null)
            .commit()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initObserver() {
        postsViewModel.postsMutableLiveData.observe(
            viewLifecycleOwner
        ) {
            if (it) {
                postsAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun initAdapter() {
        postsAdapter = PostsAdapter(postsViewModel.posts)
        binding.recyclerPosts.adapter = postsAdapter


    }

    private fun initViewModels() {
        postsViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                PostsRepository()
            )
        )[PostsViewModel::class.java]
    }

    private fun initViews() {
        binding.recyclerPosts.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    private fun bottomNavigation(){
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.profile -> currentFragment(ProfileFragment())

                R.id.myPost -> currentFragment(MyPostFragment())

                R.id.aboutUs -> currentFragment(AboutProjectFragment())
            }

            true
        }
    }
    private fun currentFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .addToBackStack(null)
            .commit()
    }

}
