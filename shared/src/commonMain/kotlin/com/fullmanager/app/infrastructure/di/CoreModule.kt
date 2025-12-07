package com.fullmanager.app.infrastructure.di

import com.fullmanager.app.core.coroutine.DefaultDispatcherProvider
import com.fullmanager.app.core.coroutine.DispatcherProvider
import com.fullmanager.app.infrastructure.network.createKtorClient
import org.koin.dsl.module

val coreModule = module {
    single { createKtorClient() }
    single<DispatcherProvider> { DefaultDispatcherProvider() }
}