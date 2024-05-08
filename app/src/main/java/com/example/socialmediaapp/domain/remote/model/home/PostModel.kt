package com.example.socialmediaapp.domain.remote.model.home

data class PostModel(
    val id: Int,
    val images: List<String>?,
    val title: String,
    val commentCount: Int,
    val comments: List<CommentsModel>?,
    val likes: Int,
    val postDate: Int,
    val owner: OwnerModel
) {
    data class OwnerModel(
        val firstName: String,
        val lastName: String,
        val profileImage: String?,
        val gender: String
    )
    data class CommentsModel(
        val commentOwner: OwnerModel,
        val comment: String
    )
}
