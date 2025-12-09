package com.fullmanager.app.presentation.screens.login

data class LoginUiState(
    val username: String = "",
    val password: String = "",
    val loadingState: LoginLoadingState = LoginLoadingState.IDLE,
    val showPassword: Boolean = true
)

sealed interface LoginEvents{
    data object OnLoginClick : LoginEvents
    data class OnUserNameChange(val username: String): LoginEvents
    data class OnPasswordChange(val password: String): LoginEvents
    data object OnShowPasswordChange: LoginEvents
}

sealed interface LoginLoadingState {
    data object IDLE: LoginLoadingState
    data object AUTHENTICATING: LoginLoadingState
}