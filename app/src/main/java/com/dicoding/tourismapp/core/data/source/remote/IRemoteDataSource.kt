package com.dicoding.tourismapp.core.data.source.remote

import androidx.lifecycle.LiveData
import com.dicoding.tourismapp.core.data.source.remote.network.ApiResponse
import com.dicoding.tourismapp.core.data.source.remote.response.TourismResponse

interface IRemoteDataSource {
    fun getAllTourism(): LiveData<ApiResponse<List<TourismResponse>>>
}