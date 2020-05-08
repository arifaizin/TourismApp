package com.dicoding.tourismapp.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity
import com.dicoding.tourismapp.core.data.TourismRepository
import com.dicoding.tourismapp.core.domain.GetFavoriteTourismUseCase
import com.dicoding.tourismapp.core.domain.Tourism
import com.dicoding.tourismapp.core.domain.UseCase

class FavoriteViewModel(private val getFavoriteTourismUseCase: GetFavoriteTourismUseCase) : ViewModel() {
    fun getFavoriteTourism(): LiveData<List<Tourism>> = getFavoriteTourismUseCase.run(UseCase.None())
}

