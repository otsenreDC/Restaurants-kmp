package com.jetbrains.handson.mpp.mobile.domain

interface IRestaurantsRepository {

    suspend fun getStats(): String
}