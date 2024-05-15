package com.example.socialmediaapp.presentation.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialmediaapp.presentation.event.login.LoginEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _uiEvent = MutableSharedFlow<LoginUIEvent>()
    val uiEvent: SharedFlow<LoginUIEvent> get() = _uiEvent

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.NavigateToRegister -> navigateToRegister()
        }
    }

    private fun navigateToRegister() {
        viewModelScope.launch {
            _uiEvent.emit(LoginUIEvent.NavigateToRegister)
        }
    }

    sealed interface LoginUIEvent {
        object NavigateToRegister : LoginUIEvent
    }
}