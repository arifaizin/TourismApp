package com.dicoding.tourismapp.core.domain

import io.reactivex.Flowable

class GetFavoriteTourismUseCase(private val tourismRepository: ITourismRepository) :
    UseCase<Flowable<List<Tourism>>, UseCase.None>() {

    override fun run(params: None)  = tourismRepository.getFavoriteTourism()

}