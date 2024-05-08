package com.example.socialmediaapp.data.remote.mapper.home

import com.example.socialmediaapp.data.remote.model.home.PostDto
import com.example.socialmediaapp.domain.remote.model.home.PostModel

fun PostDto.toDomain(): PostModel {
    val ownerModel = PostModel.OwnerModel(
        firstName = owner.firstName,
        lastName = owner.lastName,
        profileImage = owner.profileImage,
        gender = owner.gender
    )
    val commentsModel = comments?.map { commentsDto ->
        PostModel.CommentsModel(
            commentOwner = ownerModel,
            comment = commentsDto.comment
        )
    }
    return PostModel(
        id = id,
        images = images,
        title = title,
        commentCount = commentCount,
        comments = commentsModel,
        likes = likes,
        postDate = postDate,
        owner = ownerModel
    )
}