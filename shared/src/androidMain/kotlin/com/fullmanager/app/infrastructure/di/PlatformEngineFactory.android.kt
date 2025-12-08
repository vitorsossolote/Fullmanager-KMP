package com.fullmanager.app.infrastructure.di

import io.ktor.client.engine.HttpClientEngine
import okhttp3.OkHttp
import org.koin.core.component.KoinComponent

actual object PlatformEngineFactory : KoinComponent {
    actual fun createEngine(): HttpClientEngine = io.ktor.client.engine.okhttp.OkHttp.create()
}