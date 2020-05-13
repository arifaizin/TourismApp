package com.dicoding.tourismapp.core.domain

class SetFavoriteTourismUseCase(private val tourismRepository: ITourismRepository) :
    UseCase<Any, SetFavoriteTourismUseCase.Params>() {

    override fun run(params: Params)  = tourismRepository.setFavoriteTourism(params.tourism, params.state)

    data class Params(val tourism: Tourism, val state: Boolean)
}