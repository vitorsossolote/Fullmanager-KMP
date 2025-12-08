package com.fullmanager.app.presentation.screens.login

data class LoginUiState(
    val username: String = "09169298000132-032",
    val password: String = "18011987",
    val loadingState: LoginLoadingState = LoginLoadingState.IDLE
)

sealed interface LoginEvents{
    data object OnLoginClick : LoginEvents
    data class OnUserNameChange(val username: String): LoginEvents
    data class OnPasswordChange(val password: String): LoginEvents
}

sealed interface LoginLoadingState {
    data object IDLE: LoginLoadingState
    data object AUTHENTICATING: LoginLoadingState
}