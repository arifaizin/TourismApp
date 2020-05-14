package com.dicoding.tourismapp.core.domain

import com.dicoding.tourismapp.core.data.Resource
import io.reactivex.Flowable

class GetAllTourismUseCase(private val tourismRepository: ITourismRepository) :
    UseCase<Flowable<Resource<List<Tourism>>>, UseCase.None>() {

    override fun run(params: None)  = tourismRepository.getAllTourism()

}