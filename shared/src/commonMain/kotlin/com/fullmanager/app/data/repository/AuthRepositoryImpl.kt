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

            if (response.data.id_usuario.isNotBlank()){
                Resource.Success(response.toDomain())
            } else {
                Resource.Error(AppError.ApiError("Erro de api"))
            }
        } catch (e: Exception){
            e.printStackTrace()
            println("Acabou dando erro: ${e.message}")
            Resource.Error(AppError.ApiError("Erro de api"))
        }

    }
}