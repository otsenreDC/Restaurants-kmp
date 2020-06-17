package com.jetbrains.handson.mpp.mobile.domain

import com.jetbrains.handson.mpp.mobile.data.CitiesResponse
import com.jetbrains.handson.mpp.mobile.data.StatsResponse
import com.jetbrains.handson.mpp.mobile.user_cases.Stats

interface IRestaurantsRepository {

    suspend fun getStats(): Stats
    suspend fun getCities(): CitiesResponse
}