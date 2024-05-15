package com.example.socialmediaapp.domain.remote.model.firebase_authorization

import com.google.firebase.auth.FirebaseUser

data class GetUserAuth(
    val user: FirebaseUser
)
