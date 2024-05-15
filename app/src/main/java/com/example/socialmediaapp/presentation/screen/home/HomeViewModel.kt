package com.example.socialmediaapp.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialmediaapp.data.common.Resource
import com.example.socialmediaapp.domain.remote.usecase.home.GetPostUseCase
import com.example.socialmediaapp.domain.remote.usecase.home.GetStoryUseCase
import com.example.socialmediaapp.presentation.event.home.HomeEvent
import com.example.socialmediaapp.presentation.mapper.home.toPresenter
import com.example.socialmediaapp.presentation.state.home.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getStoryUseCase: GetStoryUseCase,
    private val getPostUseCase: GetPostUseCase
) : ViewModel() {

    private val _homeState = MutableStateFlow(HomeState())
    val homeState: SharedFlow<HomeState> = _homeState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<UIEvent>()
    val uiEvent: SharedFlow<UIEvent> get() = _uiEvent

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.GetStories -> getStories()
            is HomeEvent.GetPosts -> getPosts()
            is HomeEvent.ResetErrorMessage -> errorMessage(message = null)
        }
    }

    private fun getStories() {
        viewModelScope.launch {
            getStoryUseCase().collect {
                when (it) {
                    is Resource.Success -> _homeState.update { currentState ->
                        currentState.copy(story = it.data.map { storyModel ->
                            storyModel.toPresenter()
                        })
                    }

                    is Resource.Error -> errorMessage(message = it.errorMessage)

                    is Resource.Loading -> _homeState.update { currentState ->
                        currentState.copy(isLoading = it.loading)
                    }
                }
            }
        }
    }

    private fun getPosts() {
        viewModelScope.launch {
            getPostUseCase().collect {
                when (it) {
                    is Resource.Success -> _homeState.update { currentState ->
                        currentState.copy(posts = it.data.map { postModel ->
                            postModel.toPresenter()
                        })
                    }

                    is Resource.Error -> errorMessage(message = it.errorMessage)
                    is Resource.Loading -> _homeState.update { currentState ->
                        currentState.copy(isLoading = it.loading)
                    }
                }
            }
        }
    }

    private fun errorMessage(message: String?) {
        _homeState.update { currentState -> currentState.copy(errorMessage = message) }
    }

    sealed interface UIEvent {

    }

}