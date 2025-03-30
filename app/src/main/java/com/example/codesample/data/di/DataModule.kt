package com.example.codesample.data.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.example.codesample.BuildConfig.BASE_URL
import com.example.codesample.data.source.local.BeerDatabase
import com.example.codesample.data.source.local.model.BeerEntity
import com.example.codesample.data.source.remote.BeerApi
import com.example.codesample.data.source.remote.RemoteMediator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

    @Provides
    @Singleton
    fun provideBeerApi(): BeerApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BeerApi::class.java)

    @Provides
    @Singleton
    fun provideBeerDatabase(
        @ApplicationContext context: Context,
    ): BeerDatabase =
        Room.databaseBuilder(
            context,
            BeerDatabase::class.java,
            "beer_database"
        ).build()

    @Provides
    @Singleton
    fun provideBeerPager(
        db: BeerDatabase,
        api: BeerApi,
    ): Pager<Int, BeerEntity> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            remoteMediator = RemoteMediator(
                db = db,
                api = api
            ),
            pagingSourceFactory = {
                db.dao.pagingSource()
            }
        )
    }
}