package com.dicoding.tourismapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DataItem(
    @field:SerializedName("thumbnail")
    val thumbnail: String,

    @field:SerializedName("address")
    val address: String,

    @field:SerializedName("like")
    val like: String,

    @field:SerializedName("latitude")
    val latitude: Double,

    @field:SerializedName("rating")
    val rating: Double,

    @field:SerializedName("caption")
    val caption: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("image1")
    val image1: String,

    @field:SerializedName("longitude")
    val longitude: Double
)

