package com.example.harajtask.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harajtask.R
import com.example.harajtask.adapter.PostAdapter
import com.example.harajtask.databinding.FragmentPostListBinding
import com.example.harajtask.viewmodel.PostListViewModel

class PostListFragment : Fragment() {

    private lateinit var binding: FragmentPostListBinding
    private lateinit var viewModel: PostListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        Log.e("fragment", "onCreateView: ")
        binding = FragmentPostListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(PostListViewModel::class.java)

        setHasOptionsMenu(true)

        val adapter = PostAdapter { post ->
            val action = PostListFragmentDirections.actionPostToDetails(post)
            findNavController().navigate(action)
        }

        binding.apply {
            recycle.setHasFixedSize(true)
            recycle.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            recycle.adapter = adapter
        }

        viewModel.posts.observe(requireActivity(), Observer {
            adapter.updatePosts(it)
        })

        viewModel.getPosts()

        return binding.root;
    }


    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}