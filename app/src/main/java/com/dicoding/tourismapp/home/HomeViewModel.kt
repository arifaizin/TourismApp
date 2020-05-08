package com.dicoding.tourismapp.home

import androidx.lifecycle.ViewModel
import com.dicoding.tourismapp.core.data.TourismRepository

class HomeViewModel(private val tourismRepository: TourismRepository) : ViewModel() {
    fun getTourism() = tourismRepository.getAllTourism()
}

