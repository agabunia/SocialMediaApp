package com.example.socialmediaapp.presentation.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialmediaapp.presentation.event.register.RegisterEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    private val _uiEvent = MutableSharedFlow<RegisterUIEvent>()
    val uiEvent: SharedFlow<RegisterUIEvent> get() = _uiEvent

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.BackToLogin -> navigateToLogin()
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