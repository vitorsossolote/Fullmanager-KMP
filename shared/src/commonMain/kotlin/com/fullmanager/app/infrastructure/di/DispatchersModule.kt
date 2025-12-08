package com.fullmanager.app.infrastructure.di

import com.fullmanager.app.core.coroutine.DefaultDispatcherProvider
import com.fullmanager.app.core.coroutine.DispatcherProvider
import org.koin.dsl.module

val dispatchersModule = module {
    single<DispatcherProvider> { DefaultDispatcherProvider() }
}