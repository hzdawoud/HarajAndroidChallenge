package com.example.harajtask.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.harajtask.databinding.PostRowBinding
import com.example.harajtask.pojo.Post
import com.example.harajtask.util.DateConverter

class PostAdapter(private val onItemClicked: (Post) -> Unit) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    var posts : List<Post>? = null

    class ViewHolder(val binding: PostRowBinding) : RecyclerView.ViewHolder(binding.root)

    fun updatePosts(list: List<Post>) {
        this.posts = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PostRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts!!.get(position)
        (holder.binding).apply {
            title.text = post.title
            username.text = post.username
            city.text = post.city
            date.text = DateConverter.getDateFromLong(post.date)

            if (post.commentCount == 0) {
                commentCount.visibility = View.INVISIBLE
            } else {
                commentCount.visibility = View.VISIBLE
                commentCount.text = "(" + post.commentCount + ")"
            }

            Glide.with(holder.binding.root)
                .load(post.thumbURL)
                .into(imageView)

            linear.setOnClickListener(View.OnClickListener {
                onItemClicked(post)
            })
        }

    }

    override fun getItemCount(): Int {
        return this.posts?.size!!
    }
}