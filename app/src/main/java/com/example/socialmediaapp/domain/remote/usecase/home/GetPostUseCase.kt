package com.example.socialmediaapp.domain.remote.usecase.home

import com.example.socialmediaapp.domain.remote.repository.home.PostRepository
import javax.inject.Inject

class GetPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke() = postRepository.getPost()
}