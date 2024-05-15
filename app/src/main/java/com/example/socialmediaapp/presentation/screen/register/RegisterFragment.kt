package com.example.socialmediaapp.presentation.screen.register

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.socialmediaapp.databinding.FragmentRegisterBinding
import com.example.socialmediaapp.presentation.base.BaseFragment
import com.example.socialmediaapp.presentation.event.register.RegisterEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    private val viewModel: RegisterViewModel by viewModels()

    override fun bind() {
    }

    override fun bindListeners() {
        binding.apply {
            btnBackToLogin.setOnClickListener {
                viewModel.onEvent(event = RegisterEvent.BackToLogin)
            }
        }
    }

    override fun bindObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiEvent.collect {
                    handleUIEvent(event = it)
                }
            }
        }
    }

    private fun handleUIEvent(event: RegisterViewModel.RegisterUIEvent) {
        when (event) {
            is RegisterViewModel.RegisterUIEvent.NavigateToLogin -> navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
    }

}