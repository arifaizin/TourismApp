package com.dicoding.tourismapp.detail

import androidx.lifecycle.ViewModel
import com.dicoding.tourismapp.core.data.TourismRepository
import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity
import com.dicoding.tourismapp.core.domain.SetFavoriteTourismUseCase
import com.dicoding.tourismapp.core.domain.Tourism

class DetailTourismViewModel(private val setFavoriteTourismUseCase: SetFavoriteTourismUseCase) : ViewModel() {
    fun setFavoriteMovie(dataMovie: Tourism, newStatus:Boolean) = setFavoriteTourismUseCase.run(SetFavoriteTourismUseCase.Params(dataMovie, newStatus))
}

