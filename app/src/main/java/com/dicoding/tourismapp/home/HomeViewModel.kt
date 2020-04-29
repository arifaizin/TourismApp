package com.dicoding.tourismapp.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity
import com.dicoding.tourismapp.core.data.TourismRepository
import com.dicoding.tourismapp.core.data.Resource

class HomeViewModel(private val tourismRepository: TourismRepository) : ViewModel() {
    fun getTourism(): LiveData<Resource<List<TourismEntity>>> = tourismRepository.getAllTourism()
}

