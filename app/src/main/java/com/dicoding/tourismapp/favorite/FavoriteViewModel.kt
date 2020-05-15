package com.dicoding.tourismapp.favorite

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.dicoding.tourismapp.core.domain.GetFavoriteTourismUseCase
import com.dicoding.tourismapp.core.domain.UseCase

class FavoriteViewModel(private val getFavoriteTourismUseCase: GetFavoriteTourismUseCase) : ViewModel() {
    fun getFavoriteTourism() = LiveDataReactiveStreams.fromPublisher(getFavoriteTourismUseCase.run(UseCase.None()))
}

