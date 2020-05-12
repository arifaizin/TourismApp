package com.dicoding.tourismapp.core.di

import android.content.Context
import com.dicoding.tourismapp.core.data.TourismRepository
import com.dicoding.tourismapp.core.data.source.local.LocalDataSource
import com.dicoding.tourismapp.core.data.source.local.room.TourismDatabase
import com.dicoding.tourismapp.core.data.source.remote.RemoteDataSource
import com.dicoding.tourismapp.core.data.source.remote.network.ApiConfig
import com.dicoding.tourismapp.core.domain.GetAllTourismUseCase
import com.dicoding.tourismapp.core.domain.GetFavoriteTourismUseCase
import com.dicoding.tourismapp.core.domain.SetFavoriteTourismUseCase
import com.dicoding.tourismapp.core.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): TourismRepository {
        val database = TourismDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideGetAllTourismUseCase(context: Context): GetAllTourismUseCase {
        val repository = provideRepository(context)
        return GetAllTourismUseCase(repository)
    }

    fun provideGetFavoriteTourismUseCase(context: Context): GetFavoriteTourismUseCase {
        val repository = provideRepository(context)
        return GetFavoriteTourismUseCase(repository)
    }

    fun provideSetFavoriteTourismUseCase(context: Context): SetFavoriteTourismUseCase {
        val repository = provideRepository(context)
        return SetFavoriteTourismUseCase(repository)
    }
}
