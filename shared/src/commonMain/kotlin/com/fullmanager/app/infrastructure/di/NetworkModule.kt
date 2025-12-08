package com.fullmanager.app.infrastructure.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module

val networkModule = module {

    single<HttpClientEngine> {
        PlatformEngineFactory.createEngine()
    }
}