package com.dicoding.tourismapp.core.domain

import com.dicoding.tourismapp.core.data.Resource
import io.reactivex.Flowable

interface ITourismRepository {

    fun getAllTourism(): Flowable<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flowable<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}
