package com.example.codesample.data.source.remote.model

import com.example.codesample.data.source.local.model.BeerEntity

data class BeerDto(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
) {
    fun toEntity() = BeerEntity(
        id = id,
        name = name,
        description = description,
        image = image,
    )
}