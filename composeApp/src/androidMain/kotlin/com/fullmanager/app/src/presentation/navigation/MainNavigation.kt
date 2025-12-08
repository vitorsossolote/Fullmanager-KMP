package com.fullmanager.app.src.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fullmanager.app.src.presentation.ui.composables.home.HomeScreen
import com.fullmanager.app.src.presentation.ui.composables.login.LoginScreen

fun NavGraphBuilder.mainNavigation(navController: NavController){
    composable(MainRoute.Home.route) {
        HomeScreen(navController)
    }
}