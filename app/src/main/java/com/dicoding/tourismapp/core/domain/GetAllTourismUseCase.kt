package com.dicoding.tourismapp.core.domain

import androidx.lifecycle.LiveData
import com.dicoding.tourismapp.core.data.Resource

class GetAllTourismUseCase(private val tourismRepository: ITourismRepository) :
    UseCase<LiveData<Resource<List<Tourism>>>, UseCase.None>() {

    override fun run(params: None)  = tourismRepository.getAllTourism()

}