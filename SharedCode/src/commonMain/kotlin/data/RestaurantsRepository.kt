package com.jetbrains.handson.mpp.mobile.data

import com.jetbrains.handson.mpp.mobile.domain.IRestaurantsRepository

class RestaurantsRepository(private val restaurantsApi: RestaurantsApi) : IRestaurantsRepository {

    override suspend fun getStats(): String {
        return restaurantsApi.stats()
    }
}