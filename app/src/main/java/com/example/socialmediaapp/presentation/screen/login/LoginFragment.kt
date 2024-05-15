package com.example.socialmediaapp.presentation.screen.login

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.socialmediaapp.databinding.FragmentLoginBinding
import com.example.socialmediaapp.presentation.base.BaseFragment
import com.example.socialmediaapp.presentation.event.login.LoginEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val viewmodel: LoginViewModel by viewModels()

    override fun bind() {
    }

    override fun bindListeners() {
        binding.apply {
            btnRegister.setOnClickListener {
                viewmodel.onEvent(event = LoginEvent.NavigateToRegister)
            }
        }
    }

    override fun bindObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewmodel.uiEvent.collect {
                    handleUIEvent(event = it)
                }
            }
        }
    }

    private fun handleUIEvent(event: LoginViewModel.LoginUIEvent) {
        when (event) {
            is LoginViewModel.LoginUIEvent.NavigateToRegister -> navigateToRegister()
        }
    }

    private fun navigateToRegister() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
    }

}