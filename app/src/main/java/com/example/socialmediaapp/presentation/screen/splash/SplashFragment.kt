package com.example.socialmediaapp.presentation.screen.splash

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.socialmediaapp.databinding.FragmentSplashBinding
import com.example.socialmediaapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    private val viewModel: SplashViewModel by viewModels()

    override fun bind() {
    }

    override fun bindListeners() {
    }

    override fun bindObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiEvent.collect {
                    uiEvent(event = it)
                }
            }
        }
    }

    private fun uiEvent(event: SplashViewModel.SplashUIEvent) {
        when (event) {
            is SplashViewModel.SplashUIEvent.NavigateToLogin -> navigateToLogin()
            is SplashViewModel.SplashUIEvent.NavigateToHome -> navigateToHome()
        }
    }

    private fun navigateToLogin() {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
    }

    private fun navigateToHome() {}

}