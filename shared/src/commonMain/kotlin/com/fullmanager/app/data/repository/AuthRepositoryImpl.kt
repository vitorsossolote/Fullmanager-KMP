package com.fullmanager.app.data.repository

import com.fullmanager.app.data.api.FullmanagerApi
import com.fullmanager.app.data.dto.login.LoginRequest
import com.fullmanager.app.data.mapper.login.toDomain
import com.fullmanager.app.domain.model.user.User
import com.fullmanager.app.domain.repository.AuthRepository
import com.fullmanager.app.domain.utils.AppError
import com.fullmanager.app.domain.utils.Resource

class AuthRepositoryImpl(
    private val api: FullmanagerApi
): AuthRepository {
    override suspend fun login(
        credentials : LoginRequest
    ): Resource<User> {

        println("Antes do try do repository")
        return try {
            println("Depois do try")
            val response = api.login(credentials)

            println("Response da api:")
            println(response)

            if (response.status && response.data?.result?.id_usuario?.isNotBlank() == true){
                Resource.Success(response.toDomain())
            } else {
                val errorMsg = response.error ?: response.message ?: "Erro desconhecido"
                Resource.Error(AppError.ApiError(errorMsg))
            }
        } catch (e: Exception){
            e.printStackTrace()
            println("Acabou dando erro: ${e.message}")
            Resource.Error(AppError.ApiError("Erro de api"))
        }

    }
}