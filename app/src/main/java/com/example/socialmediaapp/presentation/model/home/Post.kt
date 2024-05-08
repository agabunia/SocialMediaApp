package com.example.socialmediaapp.presentation.model.home

data class Post(
    val id: Int,
    val images: List<String>?,
    val title: String,
    val commentCount: Int,
    val comments: List<Comments>?,
    val likes: Int,
    val postDate: Int,
    val owner: Owner
) {
    data class Owner(
        val firstName: String,
        val lastName: String,
        val profileImage: String?,
        val gender: String
    )

    data class Comments(
        val commentOwner: Owner,
        val comment: String
    )
}

