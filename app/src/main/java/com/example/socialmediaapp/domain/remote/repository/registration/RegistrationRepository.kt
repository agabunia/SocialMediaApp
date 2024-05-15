package com.example.socialmediaapp.domain.remote.repository.registration

import com.example.socialmediaapp.data.common.Resource
import com.example.socialmediaapp.domain.remote.model.firebase_authorization.GetUserAuth
import kotlinx.coroutines.flow.Flow

interface RegistrationRepository {
    suspend fun registration(email: String, password: String): Flow<Resource<GetUserAuth>>
}