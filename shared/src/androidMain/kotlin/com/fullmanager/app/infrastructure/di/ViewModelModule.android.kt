package com.fullmanager.app.infrastructure.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.fullmanager.app.presentation.screens.login.LoginViewModel

val viewModelModule = module {
    factory {
        LoginViewModel(
            get(),
            get(),
        )
    }
}
