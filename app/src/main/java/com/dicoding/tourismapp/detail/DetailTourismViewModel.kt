package com.dicoding.tourismapp.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.dicoding.tourismapp.core.domain.SetFavoriteTourismUseCase
import com.dicoding.tourismapp.core.domain.Tourism

class DetailTourismViewModel @ViewModelInject constructor(private val setFavoriteTourismUseCase: SetFavoriteTourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) =
        tourismUseCase.setFavoriteTourism(tourism, newStatus)
}

