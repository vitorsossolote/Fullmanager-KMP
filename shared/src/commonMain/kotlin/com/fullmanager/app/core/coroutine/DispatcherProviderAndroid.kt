package com.fullmanager.app.core.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class DispatcherProviderAndroid : DispatcherProvider {
    override val Main = Dispatchers.Main
    override val IO = Dispatchers.IO
    override val Default = Dispatchers.Default
}