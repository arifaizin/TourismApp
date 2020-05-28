package com.dicoding.tourismapp.core.domain

import javax.inject.Inject

class SetFavoriteTourismUseCase @Inject constructor(private val tourismRepository: ITourismRepository) :
    UseCase<Any, SetFavoriteTourismUseCase.Params>() {

    override fun run(params: Params) = tourismRepository.setFavoriteTourism(params.tourism, params.state)

    data class Params(val tourism: Tourism, val state: Boolean)
}