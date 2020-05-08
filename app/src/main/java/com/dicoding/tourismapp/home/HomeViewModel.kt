package com.dicoding.tourismapp.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity
import com.dicoding.tourismapp.core.data.Resource
import com.dicoding.tourismapp.core.domain.GetAllTourismUseCase
import com.dicoding.tourismapp.core.domain.Tourism
import com.dicoding.tourismapp.core.domain.UseCase

class HomeViewModel(private val getAllTourismUseCase: GetAllTourismUseCase) : ViewModel() {
    fun getTourism(): LiveData<Resource<List<Tourism>>> = getAllTourismUseCase.run(UseCase.None())
}

