package com.fullmanager.app.infrastructure.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

actual fun createHttpClient() = HttpClient(OkHttp) {
    install(Logging){
        level = LogLevel.ALL
    }

    install(ContentNegotiation){
        json(Json{
            ignoreUnknownKeys = true
            prettyPrint = true
            isLenient = true
        })
    }

    install(DefaultRequest) {
        url("https://ws.fullmanager.me/")

        header("X-API-KEY", "fullM2MwsdE456sdfSdfSdfddsaDdsDsddGrzj0N")
        header("X-SECRET-KEY", "Ws35HgtfdRe79HMds46hDGO467fdf78kKlFm34r7")
        header("Accept", "application/json")
    }
}