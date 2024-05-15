package com.example.socialmediaapp.domain.remote.usecase.validation.user

class PasswordRepeatValidationUseCase {
    operator fun invoke(password: String, repeatedPassword: String): Boolean {
        return password.isNotBlank()
                && repeatedPassword.isNotBlank()
                && password == repeatedPassword
    }
}