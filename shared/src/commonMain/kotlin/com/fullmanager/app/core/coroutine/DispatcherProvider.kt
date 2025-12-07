package com.fullmanager.app.core.coroutine

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val Main: CoroutineDispatcher
    val IO: CoroutineDispatcher
    val Default: CoroutineDispatcher
}