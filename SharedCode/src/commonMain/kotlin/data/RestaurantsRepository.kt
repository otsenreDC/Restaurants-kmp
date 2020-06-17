package com.jetbrains.handson.mpp.mobile.data

import com.jetbrains.handson.mpp.mobile.domain.IRestaurantsRepository
import com.jetbrains.handson.mpp.mobile.user_cases.Stats

class RestaurantsRepository(private val restaurantsApi: RestaurantsApi) : IRestaurantsRepository {

    override suspend fun getStats(): Stats =
        StatsMapper.toStats(restaurantsApi.getStats())

    override suspend fun getCities(): CitiesResponse = restaurantsApi.getCities()
}

private object StatsMapper {
    fun toStats(from: StatsResponse): Stats =
        with(from) {
            Stats(countries, cities, restaurants)
        }
}