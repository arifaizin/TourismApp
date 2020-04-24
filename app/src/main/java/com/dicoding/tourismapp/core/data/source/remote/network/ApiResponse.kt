package com.dicoding.tourismapp.core.data.source.remote.network

import androidx.annotation.Nullable

class ApiResponse<T>(
    val status: StatusResponse, @param:Nullable @field:Nullable
    val body: T, @param:Nullable @field:Nullable
    val message: String?
) {
    companion object {

        fun <T> success(@Nullable body: T): ApiResponse<T> {
            return ApiResponse(
                StatusResponse.SUCCESS,
                body,
                null
            )
        }
    }

}