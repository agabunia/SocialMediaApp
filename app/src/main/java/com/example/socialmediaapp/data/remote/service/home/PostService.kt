package com.example.socialmediaapp.data.remote.service.home

import com.example.socialmediaapp.data.remote.model.home.PostDto
import retrofit2.Response
import retrofit2.http.GET

interface PostService {
    @GET("https://run.mocky.io/v3/b42efa2b-a88b-4b29-bf87-3a8295411bbe")
    suspend fun getPost(): Response<List<PostDto>>
}