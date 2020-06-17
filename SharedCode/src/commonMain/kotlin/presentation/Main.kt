package com.jetbrains.handson.mpp.mobile.presentation

import com.jetbrains.handson.mpp.mobile.user_cases.GetRestaurantsStatsUseCase

class Main() : MainInteractor {

    override fun loadMain(presenter: MainPresenter) {
        GetRestaurantsStatsUseCase().execute {
            presenter.loading(true)
            presenter.numberOfCities("${it.cities} cities")
            presenter.numberOfRestaurants("${it.restaurants} restaurants")
            presenter.numberOfCountries("${it.countries} countries")
            presenter.loading(false)
        }
    }

}

interface MainPresenter {
    fun numberOfCities(value: String)
    fun numberOfRestaurants(value: String)
    fun numberOfCountries(value: String)
    fun loading(isLoading: Boolean)
}

interface MainInteractor {
    fun loadMain(presenter: MainPresenter)
}