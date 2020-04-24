package com.dicoding.tourismapp.core.utils

import android.content.Context
import com.dicoding.tourismapp.R
import com.dicoding.tourismapp.core.data.source.remote.response.DataItem
import com.dicoding.tourismapp.core.data.source.remote.response.TourismResponse
import com.google.gson.Gson
import org.json.JSONException
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(): String? {
        val jsonString: String
        try {
            jsonString = context.resources.openRawResource(R.raw.tourism).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun loadData(): List<DataItem> {
        var list = ArrayList<DataItem>()
        try {
            val response = parsingFileToString()

            val gson = Gson()
            val responseData = gson.fromJson(response, TourismResponse::class.java)
            list = responseData.data as ArrayList<DataItem>
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}

