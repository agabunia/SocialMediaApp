package com.example.socialmediaapp.domain.remote.usecase.home

import com.example.socialmediaapp.domain.remote.repository.home.StoryRepository
import javax.inject.Inject

class GetStoryUseCase @Inject constructor(
    private val storyRepository: StoryRepository
) {
    suspend operator fun invoke() = storyRepository.getStory()
}