package com.example.harajtask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.harajtask.databinding.FragmentPostDetailsBinding
import com.example.harajtask.pojo.Post
import com.example.harajtask.util.DateConverter
import com.example.harajtask.viewmodel.PostDetailsViewModel

class PostDetailsFragment : Fragment() {

    val args: PostDetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentPostDetailsBinding.inflate(inflater, container, false)
//        val viewModel = ViewModelProvider(this).get(PostDetailsViewModel::class.java)

        val post: Post = args.post

        binding.title.text = post.title
        binding.username.text = post.username
        binding.date.text = DateConverter.getDateFromLong(post.date)
        binding.city.text = post.city
        binding.body.text = post.body

        Glide.with(requireActivity())
            .load(post.thumbURL)
            .into(binding.image)

        return binding.root;
    }
}