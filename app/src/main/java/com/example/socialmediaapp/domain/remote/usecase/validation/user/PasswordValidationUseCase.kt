package com.example.socialmediaapp.domain.remote.usecase.validation.user

class PasswordValidationUseCase {
    operator fun invoke(password: String): Boolean {
        return password.isNotBlank()
    }
}