package com.dicoding.tourismapp.core.data.source.remote

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.tourismapp.core.data.source.remote.network.ApiResponse
import com.dicoding.tourismapp.core.data.source.remote.response.TourismResponse
import com.dicoding.tourismapp.core.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getAllTourism(): LiveData<ApiResponse<List<TourismResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<TourismResponse>>>()

        //get data from local json
        val handler = Handler()
        handler.postDelayed({
            val dataArray = jsonHelper.loadData()
            if (dataArray.isNotEmpty()) {
                resultData.value = ApiResponse.success(dataArray)
            }
        }, 2000)

        return resultData
    }
}

