package com.dicoding.tourismapp.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.tourismapp.core.domain.SetFavoriteTourismUseCase
import com.dicoding.tourismapp.core.domain.Tourism
import kotlinx.coroutines.launch

class DetailTourismViewModel(private val setFavoriteTourismUseCase: SetFavoriteTourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) =
//        setFavoriteTourismUseCase.invoke(viewModelScope, SetFavoriteTourismUseCase.Params(tourism, newStatus))
        setFavoriteTourismUseCase.run(SetFavoriteTourismUseCase.Params(tourism, newStatus))
}

