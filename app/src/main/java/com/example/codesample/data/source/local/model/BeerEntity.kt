package com.example.codesample.data.source.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.codesample.domain.model.Beer

@Entity(tableName = "beers")
data class BeerEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
) {
    fun toDomain() = Beer(
        id = id,
        name = name,
        description = description,
        image = image,
    )
}