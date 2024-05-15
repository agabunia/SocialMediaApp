package com.example.socialmediaapp.data.remote.mapper.firebase_authorization

import com.example.socialmediaapp.data.remote.model.firebase_authorization.UserAuthDto
import com.example.socialmediaapp.domain.remote.model.firebase_authorization.GetUserAuth

fun UserAuthDto.toDomain(): GetUserAuth {
    return GetUserAuth(user = user)
}