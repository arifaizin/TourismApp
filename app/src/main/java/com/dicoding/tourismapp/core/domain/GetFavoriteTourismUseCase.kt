package com.dicoding.tourismapp.core.domain

import androidx.lifecycle.LiveData

class GetFavoriteTourismUseCase(private val tourismRepository: ITourismRepository) :
    UseCase<LiveData<List<Tourism>>, UseCase.None>() {

    override fun run(params: None)  = tourismRepository.getFavoriteTourism()

}