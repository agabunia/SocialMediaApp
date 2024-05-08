package com.example.socialmediaapp.data.remote.repository.home

import com.example.socialmediaapp.data.common.HandleResponse
import com.example.socialmediaapp.data.common.Resource
import com.example.socialmediaapp.data.remote.mapper.base.asResource
import com.example.socialmediaapp.data.remote.mapper.home.toDomain
import com.example.socialmediaapp.data.remote.service.home.PostService
import com.example.socialmediaapp.domain.remote.model.home.PostModel
import com.example.socialmediaapp.domain.remote.repository.home.PostRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val handleResponse: HandleResponse,
    private val postService: PostService
) : PostRepository {
    override suspend fun getPost(): Flow<Resource<List<PostModel>>> {
        return handleResponse.safeApiCall {
            postService.getPost()
        }.asResource { list ->
            list.map {
                it.toDomain()
            }
        }
    }
}