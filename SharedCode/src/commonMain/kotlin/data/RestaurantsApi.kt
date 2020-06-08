package com.jetbrains.handson.mpp.mobile.data

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.Url

class RestaurantsApi {

    private val client = HttpClient()

    private val baseUrl = Url("http://opentable.herokuapp.com/api")
    private val stats = "/stats"

    suspend fun stats(): String {
        return client.get {
            url("${this@RestaurantsApi.baseUrl}$stats")
        }
    }
}