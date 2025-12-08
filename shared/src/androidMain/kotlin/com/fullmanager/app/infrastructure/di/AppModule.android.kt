package com.fullmanager.app.infrastructure.di

import android.R.attr.level
import com.fullmanager.app.core.coroutine.createDispatchers
import com.fullmanager.app.data.api.FullmanagerApi
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

actual val platformModule = module {

    single<HttpClient> {
        HttpClient(OkHttp) {
            install(Logging) { level = LogLevel.ALL }

            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    ignoreUnknownKeys = true
                })
            }

            install(DefaultRequest) {
                url("https://ws.fullmanager.me/")
                header("secret-key", "Ws35HgtfdRe79HMds46hDGO467fdf78kKlFm34r7")
                header("api-key", "fullM2MwsdE456sdfSdfSdfddsaDdsDsddGrzj0N")
            }
        }
    }

    single { createHttpClient() }
}
