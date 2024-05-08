package com.example.socialmediaapp.presentation.screen.home

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.socialmediaapp.databinding.FragmentHomeBinding
import com.example.socialmediaapp.presentation.adapter.home.PostRecyclerAdapter
import com.example.socialmediaapp.presentation.adapter.home.StoryRecyclerAdapter
import com.example.socialmediaapp.presentation.base.BaseFragment
import com.example.socialmediaapp.presentation.event.home.HomeEvent
import com.example.socialmediaapp.presentation.state.home.HomeState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var storyRecyclerAdapter: StoryRecyclerAdapter
    private lateinit var postRecyclerAdapter: PostRecyclerAdapter

    override fun bind() {
        setStoryAdapter()
        setPostAdapter()
    }

    override fun bindListeners() {
    }

    override fun bindObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.homeState.collect {
                    handleState(it)
                }
            }
        }
    }

    private fun handleState(state: HomeState) {
        state.story?.let {
            storyRecyclerAdapter.submitList(it)
        }

        state.posts?.let {
            postRecyclerAdapter.submitList(it)
        }

        state.errorMessage?.let {
            toastMessage(it)
            viewModel.onEvent(HomeEvent.ResetErrorMessage)
        }
    }

    private fun setStoryAdapter() {
        storyRecyclerAdapter = StoryRecyclerAdapter()
        binding.rvHomeWrapper.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = storyRecyclerAdapter
        }
        viewModel.onEvent(HomeEvent.GetStories)
        viewModel.onEvent(HomeEvent.GetPosts)
    }

    private fun setPostAdapter() {
        postRecyclerAdapter = PostRecyclerAdapter()
        binding.rvPosts.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = postRecyclerAdapter
        }
    }

    private fun toastMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

}