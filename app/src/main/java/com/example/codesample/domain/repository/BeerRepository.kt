package com.example.codesample.domain.repository

import com.example.codesample.data.Resource
import com.example.codesample.domain.model.Beer
import kotlinx.coroutines.flow.Flow

interface BeerRepository {
    fun getBeerFlow(page: Int): Flow<Resource<List<Beer>>>
}