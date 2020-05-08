package com.dicoding.tourismapp.core.domain

import androidx.lifecycle.LiveData
import com.dicoding.tourismapp.core.data.Resource
import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity

class SetFavoriteTourismUseCase(private val tourismRepository: ITourismRepository) :
    UseCase<LiveData<Resource<List<Tourism>>>, SetFavoriteTourismUseCase.Params>() {

    override fun run(params: Params)  = tourismRepository.setFavoriteTourism(params.entity, params.state)

    data class Params(val entity: Tourism, val state: Boolean)
}