package com.example.socialmediaapp.presentation.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialmediaapp.domain.remote.usecase.registration.UserRegistrationUseCase
import com.example.socialmediaapp.domain.remote.usecase.validation.user.EmailValidationUseCase
import com.example.socialmediaapp.domain.remote.usecase.validation.user.PasswordRepeatValidationUseCase
import com.example.socialmediaapp.domain.remote.usecase.validation.user.UsernameValidationUseCase
import com.example.socialmediaapp.presentation.event.register.RegisterEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val emailValidationUseCase: EmailValidationUseCase,
    private val passwordRepeatValidationUseCase: PasswordRepeatValidationUseCase,
    private val usernameValidationUseCase: UsernameValidationUseCase,
    private val userRegistrationUseCase: UserRegistrationUseCase
) : ViewModel() {

    private val _uiEvent = MutableSharedFlow<RegisterUIEvent>()
    val uiEvent: SharedFlow<RegisterUIEvent> get() = _uiEvent

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.BackToLogin -> navigateToLogin()
            is RegisterEvent.Register -> registerUser(
                email = event.email,
                username = event.username,
                password = event.password,
                repeatedPassword = event.repeatedPassword
            )
        }
    }

    private fun registerUser(
        email: String,
        username: String,
        password: String,
        repeatedPassword: String
    ) {
        val isEmailValid = emailValidationUseCase(email = email)
        val isUsernameValid = usernameValidationUseCase(username = username)
        val arePasswordValid = passwordRepeatValidationUseCase(
            password = password,
            repeatedPassword = repeatedPassword
        )

        if (isEmailValid && isUsernameValid && arePasswordValid) {
            registration(email = email, password = password)
        }
    }

    private fun registration(email: String, password: String) {
        viewModelScope.launch {
            userRegistrationUseCase(email = email, password = password)
        }
    }

    private fun navigateToLogin() {
        viewModelScope.launch {
            _uiEvent.emit(RegisterUIEvent.NavigateToLogin)
        }
    }

    sealed interface RegisterUIEvent {
        object NavigateToLogin : RegisterUIEvent
    }
}