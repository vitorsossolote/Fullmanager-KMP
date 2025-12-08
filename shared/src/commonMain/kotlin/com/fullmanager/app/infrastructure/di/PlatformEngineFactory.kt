package com.fullmanager.app.infrastructure.di

import io.ktor.client.engine.*
import org.koin.core.component.KoinComponent

expect object PlatformEngineFactory : KoinComponent {
    fun createEngine(): HttpClientEngine
}
