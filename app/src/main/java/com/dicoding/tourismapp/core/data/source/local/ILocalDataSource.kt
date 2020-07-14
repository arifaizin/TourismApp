package com.dicoding.tourismapp.core.data.source.local

import androidx.lifecycle.LiveData
import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity

interface ILocalDataSource {
    fun getAllTourism(): LiveData<List<TourismEntity>>
    fun getFavoriteTourism(): LiveData<List<TourismEntity>>
    fun insertTourism(tourismList: List<TourismEntity>)
    fun setFavoriteTourism(tourism: TourismEntity, newState: Boolean)
}