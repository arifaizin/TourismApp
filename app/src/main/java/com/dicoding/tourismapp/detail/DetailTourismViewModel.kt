package com.dicoding.tourismapp.detail

import androidx.lifecycle.ViewModel
import com.dicoding.tourismapp.core.domain.SetFavoriteTourismUseCase
import com.dicoding.tourismapp.core.domain.Tourism

class DetailTourismViewModel(private val setFavoriteTourismUseCase: SetFavoriteTourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) =
        setFavoriteTourismUseCase.run(SetFavoriteTourismUseCase.Params(tourism, newStatus))
}

