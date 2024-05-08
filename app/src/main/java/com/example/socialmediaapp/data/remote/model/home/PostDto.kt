package com.example.socialmediaapp.data.remote.model.home

import com.squareup.moshi.Json

data class PostDto(
    @Json(name = "id")
    val id: Int,
    @Json(name = "images")
    val images: List<String>?,
    @Json(name = "title")
    val title: String,
    @Json(name = "comment_number")
    val commentCount: Int,
    @Json(name = "comments")
    val comments: List<CommentsDto>?,
    @Json(name = "likes")
    val likes: Int,
    @Json(name = "post_date")
    val postDate: Int,
    @Json(name = "owner")
    val owner: OwnerDto
) {
    data class OwnerDto(
        @Json(name = "first_name")
        val firstName: String,
        @Json(name = "last_name")
        val lastName: String,
        @Json(name = "profile_image")
        val profileImage: String?,
        @Json(name = "gender")
        val gender: String
    )
    data class CommentsDto(
        @Json(name = "comment_owner")
        val commentOwner: OwnerDto,
        @Json(name = "comment")
        val comment: String
    )
}
