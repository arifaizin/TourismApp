package com.dicoding.tourismapp.home

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.dicoding.tourismapp.core.domain.GetAllTourismUseCase
import com.dicoding.tourismapp.core.domain.UseCase

class HomeViewModel(private val getAllTourismUseCase: GetAllTourismUseCase) : ViewModel() {
    fun getTourism() = LiveDataReactiveStreams.fromPublisher(getAllTourismUseCase.run(UseCase.None()))
}

