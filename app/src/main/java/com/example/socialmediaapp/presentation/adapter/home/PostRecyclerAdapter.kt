package com.example.socialmediaapp.presentation.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.socialmediaapp.databinding.PostLayoutBinding
import com.example.socialmediaapp.presentation.model.home.Post

class PostRecyclerAdapter : ListAdapter<Post, PostRecyclerAdapter.PostViewHolder>(PostDiffUtil()) {

    class PostDiffUtil : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        return PostViewHolder(PostLayoutBinding.inflate(inflate, parent, false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind()
    }

    inner class PostViewHolder(private val binding: PostLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var post: Post
        fun bind() {
            post = currentList[adapterPosition]

            with(binding) {
                tvTitle.text = post.title
            }
        }
    }

}