package com.dicoding.tourismapp.core.data.source.local

import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity
import com.dicoding.tourismapp.core.data.source.local.room.TourismDao
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class LocalDataSource private constructor(private val tourismDao: TourismDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(tourismDao: TourismDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(tourismDao)
            }
    }

    fun getAllTourism(): Flowable<List<TourismEntity>> = tourismDao.getAllTourism()

    fun getFavoriteTourism(): Flowable<List<TourismEntity>> = tourismDao.getFavoriteTourism()

    fun insertTourism(tourismList: List<TourismEntity>) =
        tourismDao.insertTourism(tourismList)

    fun setFavoriteTourism(tourism: TourismEntity, newState: Boolean): Completable {
        tourism.isFavorite = newState
        return tourismDao.updateFavoriteTourism(tourism)
    }
}