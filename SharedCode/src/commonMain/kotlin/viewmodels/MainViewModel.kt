package com.jetbrains.handson.mpp.mobile.viewmodels

import com.jetbrains.handson.mpp.mobile.user_cases.GetRestaurantsStatsUseCase

class MainViewModel : ViewModel() {

    private val getRestaurantsStatsUseCase = GetRestaurantsStatsUseCase()

    val loading: LiveData<Boolean> = LiveData()
    val countries: LiveData<String> = LiveData()
    val cities: LiveData<String> = LiveData()
    val restaurants: LiveData<String> = LiveData()

    fun loadData() {
        loading.postValue(true)
        getRestaurantsStatsUseCase.execute {
            countries.postValue("${it.countries} countries")
            cities.postValue("${it.cities} cities")
            restaurants.postValue("${it.restaurants} restaurants")
            loading.postValue(false)
        }
    }
}