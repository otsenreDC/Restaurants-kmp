package com.jetbrains.handson.mpp.mobile

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual fun platformName(): String {
    return "Android"
}

//internal actual val ApplicationDispatcher: CoroutineDispatcher = Dispatchers.Main
internal actual val ApplicationDispatcher: CoroutineDispatcher = Dispatchers.IO