package com.fullmanager.app.src.presentation.ui.composables.home

import android.R.attr.onClick
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fullmanager.app.src.presentation.navigation.AuthRoute
import com.fullmanager.app.src.presentation.navigation.MainRoute

@Composable
fun HomeScreen(
    navController: NavController
) {
    HomeContent(
        onClick = {
            navController.navigate(
                AuthRoute.Login.route
            )
        }
    )
}

@Composable
private fun HomeContent(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Tela de Home",
            color = Color.Black,
            fontSize = 26.sp,
            modifier = Modifier.clickable(
                onClick = onClick
            )
        )
    }
}