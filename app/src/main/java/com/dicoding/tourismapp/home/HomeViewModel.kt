package com.dicoding.tourismapp.home

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.dicoding.tourismapp.core.domain.usecase.TourismUseCase

    fun getTourism() = LiveDataReactiveStreams.fromPublisher(getAllTourismUseCase.run(UseCase.None()))
class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism()
}

