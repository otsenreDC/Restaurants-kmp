package com.jetbrains.handson.mpp.mobile

import kotlinx.coroutines.CoroutineDispatcher

expect fun platformName(): String

fun createApplicationScreenMessage() : String {
    return "Kotlin Rocks on ${platformName()}"
}

//internal suspend fun helloCoroutine() {
//    println("Hello Coroutines!")
//}

internal expect val ApplicationDispatcher: CoroutineDispatcher
