package com.example.codesample.presentation.model

data class BeerUiModel(
    val id: Int = 0,
    val name: String = "",
    val tagline: String = "",
    val firstBrewed: String = "",
    val description: String = "",
    val image: String = "",
    val abv: Double = 0.0,
)