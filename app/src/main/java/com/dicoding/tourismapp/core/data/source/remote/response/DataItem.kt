package com.dicoding.tourismapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DataItem(
    @field:SerializedName("thumbnail")
    val thumbnail: String? = null,

    @field:SerializedName("address")
    val address: String? = null,

    @field:SerializedName("like")
    val like: String? = null,

    @field:SerializedName("latitude")
    val latitude: Double? = null,

    @field:SerializedName("rating")
    val rating: Double? = null,

    @field:SerializedName("caption")
    val caption: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("image1")
    val image1: String? = null,

    @field:SerializedName("longitude")
    val longitude: Double? = null
)

