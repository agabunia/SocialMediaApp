package com.example.socialmediaapp.data.remote.repository.registration

import com.example.socialmediaapp.data.common.Resource
import com.example.socialmediaapp.data.common.await
import com.example.socialmediaapp.data.remote.mapper.firebase_authorization.toDomain
import com.example.socialmediaapp.data.remote.model.firebase_authorization.UserAuthDto
import com.example.socialmediaapp.domain.remote.model.firebase_authorization.GetUserAuth
import com.example.socialmediaapp.domain.remote.repository.registration.RegistrationRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RegistrationRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
): RegistrationRepository {
    override suspend fun registration(
        email: String,
        password: String
    ): Flow<Resource<GetUserAuth>> {
        return flow {
            emit(Resource.Loading(loading = true))
            try {
                val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
                emit(Resource.Success(UserAuthDto(user = result.user!!).toDomain()))
            } catch (e: FirebaseAuthException) {
                emit(Resource.Error(errorMessage = e.message.toString()))
            }
            emit(Resource.Loading(loading = false))
        }
    }
}