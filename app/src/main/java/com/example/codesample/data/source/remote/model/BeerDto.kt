package com.example.codesample.data.source.remote.model

import com.example.codesample.data.source.local.model.BeerEntity
import com.google.gson.annotations.SerializedName

data class BeerDto(
    val id: Int,
    val name: String,
    val tagline: String,
    @SerializedName("first_brewed")
    val firstBrewed: String,
    val description: String,
    val image: String,
    val abv: Double,
) {
    fun toEntity() = BeerEntity(
        id = id,
        name = name,
        tagline = tagline,
        firstBrewed = firstBrewed,
        description = description,
        image = image,
        abv = abv
    )
}