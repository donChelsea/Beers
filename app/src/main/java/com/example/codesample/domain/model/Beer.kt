package com.example.codesample.domain.model

import com.example.codesample.presentation.model.BeerUiModel

data class Beer(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
) {
    fun toUiModel() = BeerUiModel(
        id = id,
        name = name,
        description = description,
        image = image,
    )
}