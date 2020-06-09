package com.dicoding.core.utils

import com.dicoding.core.data.source.local.entity.TourismEntity
import com.dicoding.core.data.source.remote.response.TourismResponse
import com.dicoding.core.domain.Tourism

object DataMapper {
    fun mapResponsesToEntities(input: List<TourismResponse>): List<TourismEntity> {
        val tourismList = ArrayList<TourismEntity>()
        input.map {
            val tourism =
                TourismEntity(
                    tourismId = it.id,
                    description = it.description,
                    name = it.name,
                    address = it.address,
                    latitude = it.latitude,
                    longitude = it.longitude,
                    like = it.like,
                    image = it.image,
                    isFavorite = false
                )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntityToDomain(input: TourismEntity) =
        Tourism(
            tourismId = input.tourismId,
            description = input.description,
            name = input.name,
            address = input.address,
            latitude = input.latitude,
            longitude = input.longitude,
            like = input.like,
            image = input.image,
            isFavorite = input.isFavorite
        )

    fun mapDomainToEntity(input: Tourism) =
        TourismEntity(
            tourismId = input.tourismId,
            description = input.description,
            name = input.name,
            address = input.address,
            latitude = input.latitude,
            longitude = input.longitude,
            like = input.like,
            image = input.image,
            isFavorite = input.isFavorite
        )
}