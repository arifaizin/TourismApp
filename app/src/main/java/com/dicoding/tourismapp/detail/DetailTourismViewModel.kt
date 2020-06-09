package com.dicoding.tourismapp.detail

import androidx.lifecycle.ViewModel
import com.dicoding.core.domain.SetFavoriteTourismUseCase
import com.dicoding.core.domain.Tourism
import javax.inject.Inject

class DetailTourismViewModel @Inject constructor(private val setFavoriteTourismUseCase: SetFavoriteTourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) =
        setFavoriteTourismUseCase.run(SetFavoriteTourismUseCase.Params(tourism, newStatus))
}

