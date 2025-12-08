package com.fullmanager.app.infrastructure.di

import io.ktor.client.HttpClient

expect fun createHttpClient(): HttpClient