package com.example.socialmediaapp.data.remote.model.home

import com.squareup.moshi.Json

data class StoryDto(
    @Json(name = "id")
    val id: Int,
    @Json(name = "cover")
    val image: String,
    @Json(name = "title")
    val title: String
)
