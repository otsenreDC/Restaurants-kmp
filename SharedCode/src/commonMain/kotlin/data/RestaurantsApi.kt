package com.jetbrains.handson.mpp.mobile.data

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.Url
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration


class RestaurantsApi {

    private val client = HttpClient() {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json(JsonConfiguration(isLenient = true, ignoreUnknownKeys = true)))
        }
    }

    private val baseUrl = Url("https://opentable.herokuapp.com/api")
    private val stats = "/stats"
    private val cities = "/cities"

    suspend fun getStats(): StatsResponse = get(stats)

    suspend fun getCities(): CitiesResponse = get(cities)

    private suspend inline fun <reified T> get(path: String): T {
        return client.get {
            url("${this@RestaurantsApi.baseUrl}$path")
        }
    }
}