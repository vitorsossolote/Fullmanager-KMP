package com.fullmanager.app.src.presentation.navigation

import kotlinx.serialization.Serializable

interface Route

sealed class MainRoute(val route: String): Route {
    data object Home: MainRoute("home")
}

sealed class AuthRoute(val route: String) : Route {
    data object Login: AuthRoute("login")
}