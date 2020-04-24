package com.dicoding.tourismapp.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tourism")
data class TourismEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tourismId")
    var tourismId: String,

    @ColumnInfo(name = "thumbnail")
    var thumbnail: String,

    @ColumnInfo(name = "address")
    var address: String,

    @ColumnInfo(name = "like")
    var like: String,

    @ColumnInfo(name = "latitude")
    var latitude: Double,

    @ColumnInfo(name = "rating")
    var rating: Double,

    @ColumnInfo(name = "caption")
    var caption: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "image1")
    var image1: String,

    @ColumnInfo(name = "longitude")
    var longitude: Double,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
) : Parcelable
