package com.dicoding.tourismapp.home

import androidx.lifecycle.ViewModel
import com.dicoding.tourismapp.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism()
class HomeViewModel(private val getAllTourismUseCase: GetAllTourismUseCase) : ViewModel() {
    fun getTourism() = getAllTourismUseCase.run(UseCase.None()).asLiveData()
}

