package com.dicoding.tourismapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

    class ApiConfig {
        companion object{
            fun getApiService(): ApiService {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://push-notifikasi-69e98.firebaseapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                return retrofit.create(ApiService::class.java)
            }
        }
    }