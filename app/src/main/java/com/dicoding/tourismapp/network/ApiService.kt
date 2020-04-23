package com.dicoding.tourismapp.network

import com.dicoding.tourismapp.model.ResponseTourism
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("wisata")
    fun getList(): Call<ResponseTourism>
}