package com.example.socialmediaapp.domain.remote.usecase.validation.user

class EmailValidationUseCase {
    private val emailRegex = Regex(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+"
    )

    operator fun invoke(email: String): Boolean {
        return email.isBlank() && email.matches(emailRegex)
    }
}