package com.fullmanager.app.src.presentation.ui.composables.login

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.fullmanager.app.presentation.screens.login.LoginEvents
import com.fullmanager.app.presentation.screens.login.LoginUiState
import com.fullmanager.app.presentation.screens.login.LoginViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject

@Composable
fun LoginScreen(
    navController: NavController,
    ) {

    val viewModel: LoginViewModel = koinInject<LoginViewModel>()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.navigationEvents.collect {route ->
            navController.navigate(route)
        }
    }

    LoginContent(
        onClick = {
            println("Clicando no login")
            viewModel.onEvent(LoginEvents.OnLoginClick)
            println("Clicou no login com os params ${state.username} e ${state.password}")
        },
        uiState = state
    )
}

@Composable
private fun LoginContent(
    onClick: () -> Unit,
    uiState: LoginUiState
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Tela de Login em ${uiState.loadingState}",
            color = Color.Black,
            fontSize = 26.sp,
            modifier = Modifier.clickable(
                onClick = { onClick() }
            )
        )
    }
}
