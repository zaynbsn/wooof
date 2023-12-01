package com.nils.woofapp.models

data class Product(
    val title: String,
    val description: String,
    val price: Double,
    val date: String,
    val place: Place,
    val author: Author,
    val isFavorite: Boolean,
    val imageUrl: String,
)
