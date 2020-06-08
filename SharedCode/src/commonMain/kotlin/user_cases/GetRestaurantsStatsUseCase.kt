package com.jetbrains.handson.mpp.mobile.user_cases

import com.jetbrains.handson.mpp.mobile.ApplicationDispatcher
import com.jetbrains.handson.mpp.mobile.data.RestaurantsApi
import com.jetbrains.handson.mpp.mobile.data.RestaurantsRepository
import com.jetbrains.handson.mpp.mobile.domain.IRestaurantsRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GetRestaurantsStatsUseCase() {

    private val restaurantsRepo: IRestaurantsRepository = RestaurantsRepository(RestaurantsApi())

    fun execute(callback: (String) -> Unit) {
        GlobalScope.apply {
            launch(ApplicationDispatcher) {
                val result = restaurantsRepo.getStats()
                callback(result)
            }
        }
    }

}