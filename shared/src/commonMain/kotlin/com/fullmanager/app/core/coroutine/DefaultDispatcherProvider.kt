package com.fullmanager.app.core.coroutine

import kotlinx.coroutines.Dispatchers

class DefaultDispatcherProvider: DispatcherProvider {
    override val Main = Dispatchers.Main // Kotlin/Native fornece Dispatchers.Main via cocoapods or kotlinx
    override val IO = Dispatchers.Default
    override val Default = Dispatchers.Default
}

expect fun createDispatchers(): DispatcherProvider
