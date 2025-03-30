package com.example.codesample.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.codesample.data.source.local.model.BeerEntity

@Database(
    entities = [BeerEntity::class],
    version = 1
)
abstract class BeerDatabase: RoomDatabase() {
    abstract val dao: BeerDao
}