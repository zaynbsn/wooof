package com.nils.woofapp.models

data class Author(
    val firstName: String,
    val lastName: String,
    val note: Double,
    val profilePictureUrl: String,
    val certified: Boolean,
)
