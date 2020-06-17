package com.jetbrains.handson.mpp.mobile.presentation

import com.jetbrains.handson.mpp.mobile.user_cases.GetRestaurantsStatsUseCase

class Main(private val presenter: MainPresenter) : MainInteractor {

    override fun loadMain() {
        GetRestaurantsStatsUseCase().execute {
            presenter.numberOfCities("${it.cities} cities")
            presenter.numberOfRestaurants("${it.restaurants} restaurants")
            presenter.numberOfCountries("${it.countries} countries")
        }
    }

}

interface MainPresenter {
    fun numberOfCities(value: String)
    fun numberOfRestaurants(value: String)
    fun numberOfCountries(value: String)
}

interface MainInteractor {
    fun loadMain()
}