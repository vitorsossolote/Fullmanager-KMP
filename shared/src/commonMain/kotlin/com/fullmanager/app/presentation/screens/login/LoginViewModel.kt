package com.fullmanager.app.presentation.screens.login

import com.fullmanager.app.core.BaseViewModel
import com.fullmanager.app.core.coroutine.DispatcherProvider
import com.fullmanager.app.domain.usecase.login.LoginUseCase
import com.fullmanager.app.domain.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    dispatchers: DispatcherProvider
): BaseViewModel(dispatchers) {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    private val _navigationEvents = MutableSharedFlow<String>()
    val navigationEvents = _navigationEvents.asSharedFlow()

    fun onEvent(event: LoginEvents){
        when(event) {
            LoginEvents.OnLoginClick -> onLoginClick()
            is LoginEvents.OnPasswordChange -> { _uiState.update { it.copy(password = event.password) }}
            is LoginEvents.OnUserNameChange -> { _uiState.update { it.copy(username = event.username) }}
        }
    }

    private fun onLoginClick(){
        println("Chegou aqui")
        viewModelScope.launch {
            println("Chegou aqui 2 ")

            _uiState.update { it.copy(
                loadingState = LoginLoadingState.AUTHENTICATING
            ) }

            val result = loginUseCase(
                username = _uiState.value.username,
                password = _uiState.value.password
            )

            when(result){
                is Resource.Error -> {
                    println("Chegou aqui 3")
                    cancelLoading()
                }
                Resource.Loading -> {
                    println("Chegou aqui 4")
                    cancelLoading()

                }
                is Resource.Success -> {
                    println("Chegou aqui 5 ")
                   cancelLoading()
                    _navigationEvents.emit(
                        "home"
                    )
                }
            }
        }
    }

    private fun cancelLoading(){
        _uiState.update { it.copy(
            loadingState = LoginLoadingState.IDLE
        ) }
    }
}