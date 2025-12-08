package com.fullmanager.app.domain.usecase.login

import com.fullmanager.app.data.dto.login.LoginRequest
import com.fullmanager.app.domain.model.user.User
import com.fullmanager.app.domain.repository.AuthRepository
import com.fullmanager.app.domain.utils.Resource

class LoginUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(username: String, password: String): Resource<User> {

        val response = repository.login(
            credentials = LoginRequest(
                username = username,
                password = password
            )
        )

        return when(response){
            is Resource.Error -> {
                println(" Erro no usecase")
                println("$username+$password")
                response
            }
            Resource.Loading -> {
                println(" Loading no usecase")
                response
            }
            is Resource.Success<*> -> {
                println(" sucesso no usecase")
                response
            }
        }
    }
}
