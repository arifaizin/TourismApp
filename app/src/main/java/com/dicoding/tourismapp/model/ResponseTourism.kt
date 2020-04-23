package com.dicoding.tourismapp.model

import com.google.gson.annotations.SerializedName

data class ResponseTourism(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null
)