package com.fullmanager.app.src.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fullmanager.app.src.presentation.ui.composables.login.LoginScreen

fun NavGraphBuilder.authNavigation(navController: NavController){
    composable(AuthRoute.Login.route) {
        LoginScreen(navController)
    }
}