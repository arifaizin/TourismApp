package com.dicoding.tourismapp.core.domain

import com.dicoding.tourismapp.core.data.Resource
import kotlinx.coroutines.flow.Flow

class GetFavoriteTourismUseCase(private val tourismRepository: ITourismRepository) :
    UseCase<Flow<List<Tourism>>, UseCase.None>() {

    override fun run(params: None)  = tourismRepository.getFavoriteTourism()

}