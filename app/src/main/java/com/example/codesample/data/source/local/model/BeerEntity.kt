package com.example.codesample.data.source.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.codesample.domain.model.Beer

@Entity(tableName = "beers")
data class BeerEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val tagline: String,
    val firstBrewed: String,
    val description: String,
    val image: String,
    val abv: Double,
) {
    fun toDomain() = Beer(
        id = id,
        name = name,
        tagline = tagline,
        firstBrewed = firstBrewed,
        description = description,
        image = image,
        abv = abv
    )
}