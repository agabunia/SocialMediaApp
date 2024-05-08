package com.example.socialmediaapp.presentation.mapper.home

import com.example.socialmediaapp.domain.remote.model.home.StoryModel
import com.example.socialmediaapp.presentation.model.home.Story

fun StoryModel.toPresenter(): Story {
    return Story(
        id = id,
        image = image,
        title = title
    )
}