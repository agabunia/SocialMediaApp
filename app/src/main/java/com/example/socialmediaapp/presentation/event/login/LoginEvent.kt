package com.example.socialmediaapp.presentation.event.login

sealed class LoginEvent {
    object NavigateToRegister : LoginEvent()
}