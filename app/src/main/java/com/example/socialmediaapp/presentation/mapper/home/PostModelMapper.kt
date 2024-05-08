package com.example.socialmediaapp.presentation.mapper.home

import com.example.socialmediaapp.domain.remote.model.home.PostModel
import com.example.socialmediaapp.presentation.model.home.Post

fun PostModel.toPresenter(): Post {
    val owner = Post.Owner(
        firstName = owner.firstName,
        lastName = owner.lastName,
        profileImage = owner.profileImage,
        gender = owner.gender
    )
    val comments = comments?.map { commentsModel ->
        Post.Comments(
            commentOwner = owner,
            comment = commentsModel.comment
        )
    }
    return Post(
        id = id,
        images = images,
        title = title,
        commentCount = commentCount,
        comments = comments,
        likes = likes,
        postDate = postDate,
        owner = owner
    )
}