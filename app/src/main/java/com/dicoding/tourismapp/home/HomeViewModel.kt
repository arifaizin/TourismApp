package com.dicoding.tourismapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.core.domain.GetAllTourismUseCase
import com.dicoding.core.domain.UseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val getAllTourismUseCase: GetAllTourismUseCase) : ViewModel() {
    fun getTourism() = getAllTourismUseCase.run(UseCase.None()).asLiveData()
}

