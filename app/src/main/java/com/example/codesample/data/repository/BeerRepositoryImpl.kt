package com.example.codesample.data.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import com.example.codesample.data.source.local.model.BeerEntity
import com.example.codesample.domain.model.Beer
import com.example.codesample.domain.repository.BeerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BeerRepositoryImpl @Inject constructor(
    private val pager: Pager<Int, BeerEntity>
) : BeerRepository {

    override fun getBeerFlow(): Flow<PagingData<Beer>> =
        pager.flow
            .transform { pagingData ->
                val transformedData = pagingData.map { it.toDomain() }
                emit(transformedData)
            }
}