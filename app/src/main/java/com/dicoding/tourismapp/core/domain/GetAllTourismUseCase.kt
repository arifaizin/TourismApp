package com.dicoding.tourismapp.core.domain

import com.dicoding.tourismapp.core.data.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTourismUseCase @Inject constructor(private val tourismRepository: ITourismRepository) :
    UseCase<Flow<Resource<List<Tourism>>>, UseCase.None>() {

    override fun run(params: None) = tourismRepository.getAllTourism()

}