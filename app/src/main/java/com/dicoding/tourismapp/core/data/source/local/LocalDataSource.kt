package com.dicoding.tourismapp.core.data.source.local

import androidx.lifecycle.LiveData
import com.dicoding.tourismapp.core.data.source.ILocalDataSource
import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity
import com.dicoding.tourismapp.core.data.source.local.room.TourismDao

class LocalDataSource private constructor(private val tourismDao: TourismDao): ILocalDataSource {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(tourismDao: TourismDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(tourismDao)
            }
    }

    override fun getAllTourism(): LiveData<List<TourismEntity>> = tourismDao.getAllTourism()

    override fun getFavoriteTourism(): LiveData<List<TourismEntity>> = tourismDao.getFavoriteTourism()

    override fun insertTourism(tourismList: List<TourismEntity>) = tourismDao.insertTourism(tourismList)

    override fun setFavoriteTourism(tourism: TourismEntity, newState: Boolean) {
        tourism.isFavorite = newState
        tourismDao.updateFavoriteTourism(tourism)
    }
}