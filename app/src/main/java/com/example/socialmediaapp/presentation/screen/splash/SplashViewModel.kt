package com.example.socialmediaapp.presentation.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _uiEvent = MutableSharedFlow<SplashUIEvent>()
    val uiEvent: SharedFlow<SplashUIEvent> get() = _uiEvent

    init {
        readSession()
    }

    private fun readSession() {
        viewModelScope.launch {
            _uiEvent.emit(SplashUIEvent.NavigateToLogin)
        }
    }

    sealed interface SplashUIEvent {
        object NavigateToLogin : SplashUIEvent
        object NavigateToHome : SplashUIEvent
    }
}