package com.example.codesample.domain.model

import com.example.codesample.presentation.model.BeerUiModel

data class Beer(
    val id: Int,
    val name: String,
    val tagline: String,
    val firstBrewed: String,
    val description: String,
    val image: String,
    val abv: Double,
) {
    fun toUiModel() = BeerUiModel(
        id = id,
        name = name,
        tagline = tagline,
        firstBrewed = firstBrewed,
        description = description,
        image = image,
        abv = abv
    )
}