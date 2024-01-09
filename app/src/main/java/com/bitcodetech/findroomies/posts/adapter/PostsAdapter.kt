package com.bitcodetech.findroomies.posts.adapter

import android.provider.ContactsContract.CommonDataKinds.StructuredPostal
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.databinding.PostsViewBinding
import com.bitcodetech.findroomies.posts.models.Post

class PostsAdapter(private val posts: ArrayList<Post>) :
    RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {
    private lateinit var binding: PostsViewBinding

    interface OnPostClickListener{
        fun onPostListener(post: Post,position: Int,postsAdapter: PostsAdapter)
    }
     var onPostClickListener : OnPostClickListener? = null


    inner class PostsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding  : PostsViewBinding

        init {
            binding = PostsViewBinding.bind(view)
            binding.root.setOnClickListener {
                onPostClickListener?.onPostListener(
                    posts[adapterPosition],
                    adapterPosition,
                    this@PostsAdapter
                )
            }
        }
//        val imagePosts: ImageView
//        val txtName: TextView
//        val txtAddress: TextView
//        val txtRent: TextView
//
//        init {
//            imagePosts = view.findViewById(R.id.imgPosts)
//            txtName = view.findViewById(R.id.txtName)
//            txtAddress = view.findViewById(R.id.txtAddress)
//            txtRent = view.findViewById(R.id.txtRent)
//        }
    }

    override fun getItemCount() = posts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.posts_view, null)
        return PostsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = posts[position]

        holder.binding.imgPosts.setImageResource(post.imageUrl)
        holder.binding.txtName.text = post.name
        holder.binding.txtAddress.text = post.address
        holder.binding.txtRent.text = post.rent.toString()
//        holder.imagePosts.setImageResource(post.imageUrl.toString().toInt())
//        holder.txtName.text = post.name
//        holder.txtAddress.text = post.address
//        holder.txtRent.text = post.rent.toString()

    }
}