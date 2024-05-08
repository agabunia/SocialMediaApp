package com.example.socialmediaapp.presentation.state.home

import com.example.socialmediaapp.presentation.model.home.Post
import com.example.socialmediaapp.presentation.model.home.Story

data class HomeState(
    val story: List<Story>? = null,
    val posts: List<Post>? = null,
    val errorMessage: String? = null,
    val isLoading: Boolean = false
)
