package com.dicoding.tourismapp.detail

import androidx.lifecycle.ViewModel
import com.dicoding.tourismapp.core.data.TourismRepository
import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity

class DetailTourismViewModel(private val tourismRepository: TourismRepository) : ViewModel() {
    fun setFavoriteMovie(dataMovie: TourismEntity, newStatus:Boolean) =
        tourismRepository.setFavoriteTourism(dataMovie, newStatus)
}

