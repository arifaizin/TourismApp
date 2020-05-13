package com.dicoding.tourismapp.core.domain

import androidx.lifecycle.LiveData
import com.dicoding.tourismapp.core.data.Resource

class SetFavoriteTourismUseCase(private val tourismRepository: ITourismRepository) :
    UseCase<Any, SetFavoriteTourismUseCase.Params>() {

    override suspend fun run(params: Params) = tourismRepository.setFavoriteTourism(params.tourism, params.state)

    data class Params(val tourism: Tourism, val state: Boolean)
}