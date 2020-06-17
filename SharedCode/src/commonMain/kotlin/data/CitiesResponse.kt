package com.jetbrains.handson.mpp.mobile.data

import kotlinx.serialization.Serializable

@Serializable
data class CitiesResponse(var count: Int = 0) {
//    var cities: Array<String> = emptyArray()
}