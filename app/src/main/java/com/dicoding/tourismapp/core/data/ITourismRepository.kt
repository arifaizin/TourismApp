package com.dicoding.tourismapp.core.data


import androidx.lifecycle.LiveData
import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity

interface ITourismRepository {

    fun getAllTourism(): LiveData<Resource<List<TourismEntity>>>

    fun getFavoriteTourism(): LiveData<List<TourismEntity>>

    fun setFavoriteTourism(tourism: TourismEntity, state: Boolean)

}