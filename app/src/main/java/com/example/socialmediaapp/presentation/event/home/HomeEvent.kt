package com.example.socialmediaapp.presentation.event.home

sealed class HomeEvent {
    object GetStories : HomeEvent()
    object GetPosts : HomeEvent()
    object ResetErrorMessage : HomeEvent()
}