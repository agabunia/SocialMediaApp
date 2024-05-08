package com.example.socialmediaapp.data.remote.repository.home

import com.example.socialmediaapp.data.common.HandleResponse
import com.example.socialmediaapp.data.common.Resource
import com.example.socialmediaapp.data.remote.mapper.base.asResource
import com.example.socialmediaapp.data.remote.mapper.home.toDomain
import com.example.socialmediaapp.data.remote.service.home.StoryService
import com.example.socialmediaapp.domain.remote.model.home.StoryModel
import com.example.socialmediaapp.domain.remote.repository.home.StoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StoryRepositoryImpl @Inject constructor(
    private val handleResponse: HandleResponse,
    private val storyService: StoryService
) : StoryRepository {
    override suspend fun getStory(): Flow<Resource<List<StoryModel>>> {
        return handleResponse.safeApiCall {
            storyService.getStory()
        }.asResource { list ->
            list.map {
                it.toDomain()
            }
        }
    }
}