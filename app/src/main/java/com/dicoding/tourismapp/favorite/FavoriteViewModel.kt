package com.dicoding.tourismapp.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity
import com.dicoding.tourismapp.core.data.TourismRepository

class FavoriteViewModel(private val tourismRepository: TourismRepository) : ViewModel() {
    fun getFavoriteTourism(): LiveData<List<TourismEntity>> = tourismRepository.getFavoriteTourism()
}

