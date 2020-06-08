package com.jetbrains.handson.mpp.mobile.user_cases

import com.jetbrains.handson.mpp.mobile.data.RestaurantsApi
import com.jetbrains.handson.mpp.mobile.data.RestaurantsRepository
import com.jetbrains.handson.mpp.mobile.domain.IRestaurantsRepository

class GetRestaurantsStatsUseCase() {

    private val restaurantsRepo: IRestaurantsRepository = RestaurantsRepository(RestaurantsApi())

    suspend fun execute(): String {
        return restaurantsRepo.getStats()
    }

}