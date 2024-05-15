package com.example.socialmediaapp.di

import com.example.socialmediaapp.data.common.HandleResponse
import com.example.socialmediaapp.data.remote.repository.home.PostRepositoryImpl
import com.example.socialmediaapp.data.remote.repository.home.StoryRepositoryImpl
import com.example.socialmediaapp.data.remote.repository.registration.RegistrationRepositoryImpl
import com.example.socialmediaapp.data.remote.service.home.PostService
import com.example.socialmediaapp.data.remote.service.home.StoryService
import com.example.socialmediaapp.domain.remote.repository.home.PostRepository
import com.example.socialmediaapp.domain.remote.repository.home.StoryRepository
import com.example.socialmediaapp.domain.remote.repository.registration.RegistrationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRegistrationRepository(impl: RegistrationRepositoryImpl): RegistrationRepository =
        impl

    @Provides
    @Singleton
    fun provideStoryRepository(
        handleResponse: HandleResponse,
        storyService: StoryService
    ): StoryRepository {
        return StoryRepositoryImpl(
            handleResponse = handleResponse,
            storyService = storyService
        )
    }

    @Provides
    @Singleton
    fun providePostRepository(
        handleResponse: HandleResponse,
        postService: PostService
    ): PostRepository {
        return PostRepositoryImpl(
            handleResponse = handleResponse,
            postService = postService
        )
    }

}