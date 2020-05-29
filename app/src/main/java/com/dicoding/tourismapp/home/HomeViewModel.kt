package com.dicoding.tourismapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.tourismapp.core.domain.GetAllTourismUseCase
import com.dicoding.tourismapp.core.domain.UseCase

class HomeViewModel (private val getAllTourismUseCase: GetAllTourismUseCase) : ViewModel() {
    fun getTourism() = getAllTourismUseCase.run(UseCase.None()).asLiveData()
}

