package com.example.codesample.domain.repository

import androidx.paging.PagingData
import com.example.codesample.domain.model.Beer
import kotlinx.coroutines.flow.Flow

interface BeerRepository {
    fun getBeerFlow(): Flow<PagingData<Beer>>
}