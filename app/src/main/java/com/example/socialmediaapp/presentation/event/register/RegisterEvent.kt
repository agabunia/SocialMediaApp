package com.example.socialmediaapp.presentation.event.register

sealed class RegisterEvent {
    object BackToLogin : RegisterEvent()
}