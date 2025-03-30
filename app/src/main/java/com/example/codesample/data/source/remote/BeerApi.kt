package com.example.codesample.data.source.remote

import com.example.codesample.data.source.remote.model.BeerDto
import retrofit2.http.GET
import retrofit2.http.Query

interface BeerApi {

    @GET("beers")
    suspend fun getBeers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): List<BeerDto>
}