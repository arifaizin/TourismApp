package com.dicoding.tourismapp.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.tourismapp.core.domain.GetAllTourismUseCase
import com.dicoding.tourismapp.core.domain.UseCase
import javax.inject.Inject

class HomeViewModel @ViewModelInject constructor(private val getAllTourismUseCase: GetAllTourismUseCase) : ViewModel() {
    fun getTourism() = getAllTourismUseCase.run(UseCase.None()).asLiveData()
}

