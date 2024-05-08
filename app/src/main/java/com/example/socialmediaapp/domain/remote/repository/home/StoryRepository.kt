package com.example.socialmediaapp.domain.remote.repository.home

import com.example.socialmediaapp.data.common.Resource
import com.example.socialmediaapp.domain.remote.model.home.StoryModel
import kotlinx.coroutines.flow.Flow

interface StoryRepository {
    suspend fun getStory(): Flow<Resource<List<StoryModel>>>
}