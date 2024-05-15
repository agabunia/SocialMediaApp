package com.example.socialmediaapp.domain.remote.usecase.validation.user

class UsernameValidationUseCase {
    operator fun invoke(username: String): Boolean {
        return username.isNotBlank()
    }
}