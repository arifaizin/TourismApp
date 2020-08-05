package com.dicoding.tourismapp.di

import com.dicoding.tourismapp.core.domain.repository.ITourismRepository
import com.dicoding.tourismapp.core.domain.usecase.TourismInteractor
import com.dicoding.tourismapp.core.domain.usecase.TourismUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class AppModule {

    @ActivityScoped
    @Provides
    fun provideTourismUseCase(
        tourismRepository: ITourismRepository
    ): TourismUseCase = TourismInteractor(tourismRepository)

}
