package com.jetbrains.handson.mpp.mobile.data

import kotlinx.serialization.Serializable

@Serializable
data class StatsResponse(val countries: Int, val cities: Int, val restaurants: Int)