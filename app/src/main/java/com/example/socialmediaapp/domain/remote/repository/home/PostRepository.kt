package com.example.socialmediaapp.domain.remote.repository.home

import com.example.socialmediaapp.data.common.Resource
import com.example.socialmediaapp.domain.remote.model.home.PostModel
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPost(): Flow<Resource<List<PostModel>>>
}