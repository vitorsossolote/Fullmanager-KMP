package com.fullmanager.app.infrastructure.di

import io.ktor.client.HttpClient
import org.koin.dsl.module

actual val platformModule = module {
    single<HttpClient> { createHttpClient() }
}
