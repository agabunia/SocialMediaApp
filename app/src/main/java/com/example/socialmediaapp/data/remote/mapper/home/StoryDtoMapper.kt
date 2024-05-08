package com.example.socialmediaapp.data.remote.mapper.home

import com.example.socialmediaapp.data.remote.model.home.StoryDto
import com.example.socialmediaapp.domain.remote.model.home.StoryModel

fun StoryDto.toDomain(): StoryModel {
    return StoryModel(
        id = id,
        image = image,
        title = title
    )
}
