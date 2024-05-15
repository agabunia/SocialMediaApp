package com.example.socialmediaapp.presentation.event.register

sealed class RegisterEvent {
    object BackToLogin : RegisterEvent()
    data class Register(
        val email: String,
        val username: String,
        val password: String,
        val repeatedPassword: String
    ) : RegisterEvent()
}