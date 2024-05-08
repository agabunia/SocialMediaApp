package com.example.socialmediaapp.data.remote.service.home

import com.example.socialmediaapp.data.remote.model.home.StoryDto
import retrofit2.Response
import retrofit2.http.GET

interface StoryService {
    @GET("https://run.mocky.io/v3/462e18d9-c2f5-43a5-aa19-289742a433ca")
    suspend fun getStory(): Response<List<StoryDto>>
}