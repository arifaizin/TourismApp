package com.dicoding.core.di

import com.dicoding.core.data.TourismRepository
import com.dicoding.core.data.source.local.LocalDataSource
import com.dicoding.core.data.source.remote.RemoteDataSource
import com.dicoding.core.domain.ITourismRepository
import com.dicoding.core.utils.AppExecutors
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [NetworkModule::class, DatabaseModule::class])
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        remote: RemoteDataSource,
        local: LocalDataSource,
        executors: AppExecutors
    ): ITourismRepository =
        TourismRepository(remote, local, executors)

}