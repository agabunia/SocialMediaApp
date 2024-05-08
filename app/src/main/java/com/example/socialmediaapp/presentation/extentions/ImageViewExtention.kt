package com.example.socialmediaapp.presentation.extentions

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.example.socialmediaapp.R

fun AppCompatImageView.loadImage(url: String?) {
    Glide.with(context)
        .load(url)
        .placeholder(R.drawable.ic_launcher_background)
        .error(R.drawable.ic_launcher_background)
        .into(this);
}