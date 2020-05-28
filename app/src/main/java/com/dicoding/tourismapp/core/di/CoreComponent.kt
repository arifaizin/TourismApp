package com.dicoding.tourismapp.core.di

import android.content.Context
import com.dicoding.tourismapp.core.data.source.local.LocalDataSource
import com.dicoding.tourismapp.core.data.source.local.room.TourismDao
import com.dicoding.tourismapp.core.data.source.local.room.TourismDatabase
import com.dicoding.tourismapp.core.data.source.remote.RemoteDataSource
import com.dicoding.tourismapp.core.domain.ITourismRepository
import com.dicoding.tourismapp.core.utils.AppExecutors
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DatabaseModule::class, NetworkModule::class, RepositoryModule::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    //harus ada ini untuk provide ke component yg depend kesini
//    fun provideDatabase(): TourismDatabase
//    fun provideTourismDao(): TourismDao
    fun provideRepository(): ITourismRepository
}