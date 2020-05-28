package com.dicoding.tourismapp.core.di

import com.dicoding.tourismapp.core.data.TourismRepository
import com.dicoding.tourismapp.core.data.source.local.LocalDataSource
import com.dicoding.tourismapp.core.data.source.remote.RemoteDataSource
import com.dicoding.tourismapp.core.data.source.remote.network.ApiService
import com.dicoding.tourismapp.core.domain.ITourismRepository
import com.dicoding.tourismapp.core.utils.AppExecutors
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
class RepositoryModule {

    @Provides
    fun provideRepository(
        remote: RemoteDataSource,
        local: LocalDataSource,
        app: AppExecutors
    ): ITourismRepository = TourismRepository(remote, local, app)

}