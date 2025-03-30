package com.example.codesample.data.repository

import com.example.codesample.data.Resource
import com.example.codesample.data.source.remote.BeerApi
import com.example.codesample.domain.model.Beer
import com.example.codesample.domain.repository.BeerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BeerRepositoryImpl @Inject constructor(
    private val api: BeerApi
): BeerRepository {

    override fun getBeerFlow(page: Int): Flow<Resource<List<Beer>>> = flow {

    }
}