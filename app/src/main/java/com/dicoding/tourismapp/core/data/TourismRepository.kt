package com.dicoding.tourismapp.core.data

import androidx.lifecycle.LiveData
import com.dicoding.tourismapp.core.data.source.remote.network.ApiResponse
import com.dicoding.tourismapp.core.data.source.local.LocalDataSource
import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity
import com.dicoding.tourismapp.core.data.source.remote.RemoteDataSource
import com.dicoding.tourismapp.core.data.source.remote.response.DataItem
import com.dicoding.tourismapp.core.utils.AppExecutors
import com.dicoding.tourismapp.core.valueobject.Resource

class TourismRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : TourismDataSource {

    companion object {
        @Volatile
        private var instance: TourismRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): TourismRepository =
            instance ?: synchronized(this) {
                instance ?: TourismRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllTourism(): LiveData<Resource<List<TourismEntity>>> {
        return object : NetworkBoundResource<List<TourismEntity>, List<DataItem>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<TourismEntity>> =
                localDataSource.getAllTourism()

            override fun shouldFetch(data: List<TourismEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<DataItem>>> =
                remoteDataSource.getAllTourism()

            public override fun saveCallResult(data: List<DataItem>) {
                val tourismList = ArrayList<TourismEntity>()
                for (response in data) {
                    val tourism = TourismEntity(
                            tourismId = response.caption,
                            thumbnail = response.thumbnail,
                            address = response.address,
                            like = response.like,
                            latitude = response.latitude,
                            rating = response.rating,
                            caption = response.caption,
                            description = response.description,
                            image1 = response.image1,
                            longitude = response.longitude,
                            isFavorite = false
                        )
                    tourismList.add(tourism)
                }

                localDataSource.insertTourism(tourismList)
            }
        }.asLiveData()
    }

    override fun getFavoriteTourism(): LiveData<List<TourismEntity>> =
        localDataSource.getFavoriteTourism()

    override fun setFavoriteTourism(tourism: TourismEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourism, state) }
}

