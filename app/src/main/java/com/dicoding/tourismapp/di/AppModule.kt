package com.dicoding.tourismapp.di

import com.dicoding.tourismapp.core.domain.repository.ITourismRepository
import com.dicoding.tourismapp.core.domain.usecase.TourismInteractor
import com.dicoding.tourismapp.core.domain.usecase.TourismUseCase
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @AppScope
    @Provides
    fun provideTourismUseCase(
        tourismRepository: ITourismRepository
    ): TourismUseCase = TourismInteractor(tourismRepository)

}
