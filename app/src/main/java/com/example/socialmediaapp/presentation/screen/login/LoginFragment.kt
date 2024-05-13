package com.example.socialmediaapp.presentation.screen.login

import androidx.fragment.app.viewModels
import com.example.socialmediaapp.databinding.FragmentLoginBinding
import com.example.socialmediaapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val viewmodel: LoginViewModel by viewModels()

    override fun bind() {
    }

    override fun bindListeners() {
    }

    override fun bindObservers() {
    }

}