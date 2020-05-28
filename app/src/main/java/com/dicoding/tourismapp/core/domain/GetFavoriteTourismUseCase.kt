package com.dicoding.tourismapp.core.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteTourismUseCase @Inject constructor(private val tourismRepository: ITourismRepository) :
    UseCase<Flow<List<Tourism>>, UseCase.None>() {

    override fun run(params: None) = tourismRepository.getFavoriteTourism()

}