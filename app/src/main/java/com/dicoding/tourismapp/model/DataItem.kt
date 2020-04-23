package com.dicoding.tourismapp.model

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("image5")
	val image5: String? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("image3")
	val image3: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("image4")
	val image4: String? = null,

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

	@field:SerializedName("image2")
	val image2: String? = null,

	@field:SerializedName("longitude")
	val longitude: Double? = null
)