package com.jetbrains.handson.mpp.mobile.viewmodels

open class ViewModel

class LiveData<T> {

    private val observers: MutableList<(T) -> Unit> = arrayListOf()
    private var storedValue: T? = null

    fun postValue(value: T) {
        storedValue = value
        observers.forEach {
            it(value)
        }
    }

    fun addObserver(observer: (T) -> Unit) {
        observers.add(observer)
    }

    fun removeObserve(observer: (T) -> Unit) {
        observers.remove(observer)
    }

    fun clear() {
        observers.clear()
    }
}