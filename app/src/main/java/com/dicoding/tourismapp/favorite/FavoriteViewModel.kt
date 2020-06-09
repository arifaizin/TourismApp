package com.dicoding.tourismapp.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.core.domain.GetFavoriteTourismUseCase
import com.dicoding.core.domain.UseCase
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(private val getFavoriteTourismUseCase: GetFavoriteTourismUseCase) : ViewModel() {
    fun getFavoriteTourism() = getFavoriteTourismUseCase.run(UseCase.None()).asLiveData()
}

