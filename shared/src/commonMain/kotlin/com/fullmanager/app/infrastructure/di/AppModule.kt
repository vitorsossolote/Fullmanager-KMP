package com.fullmanager.app.infrastructure.di

import com.fullmanager.app.core.coroutine.DispatcherProvider
import com.fullmanager.app.core.coroutine.createDispatchers
import com.fullmanager.app.data.api.FullmanagerApi
import com.fullmanager.app.data.repository.AuthRepositoryImpl
import com.fullmanager.app.domain.repository.AuthRepository
import com.fullmanager.app.domain.usecase.login.LoginUseCase
import com.fullmanager.app.presentation.screens.login.LoginViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DataConversion.install
import io.ktor.client.plugins.DefaultRequest
import io.ktor.http.URLBuilder
import io.ktor.http.buildUrl
import io.ktor.http.parseUrl
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule = module {

    // Dispatchers (platform-specific)
    single<DispatcherProvider> { createDispatchers() }

    // Api
    single<FullmanagerApi> { FullmanagerApi(
        client = get()
    ) }

    // Repository
    single<AuthRepository> { AuthRepositoryImpl(get()) }

    // UseCase
    factory { LoginUseCase(get()) }

    // ViewModel with dependencies
    factory {
        LoginViewModel(
            loginUseCase = get(),
            dispatchers = get()
        )
    }
}

expect val platformModule: Module
