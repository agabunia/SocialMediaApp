package com.example.socialmediaapp.domain.remote.usecase.registration

import com.example.socialmediaapp.domain.remote.repository.registration.RegistrationRepository
import javax.inject.Inject

class UserRegistrationUseCase @Inject constructor(private val registrationRepository: RegistrationRepository) {
    suspend operator fun invoke(email: String, password: String) =
        registrationRepository.registration(email = email, password = password)
}