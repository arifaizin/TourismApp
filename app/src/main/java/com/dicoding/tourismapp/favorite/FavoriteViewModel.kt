package com.dicoding.tourismapp.favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.tourismapp.core.domain.GetFavoriteTourismUseCase
import com.dicoding.tourismapp.core.domain.UseCase

class FavoriteViewModel @ViewModelInject constructor(private val getFavoriteTourismUseCase: GetFavoriteTourismUseCase) : ViewModel() {
    fun getFavoriteTourism() = getFavoriteTourismUseCase.run(UseCase.None()).asLiveData()
}

