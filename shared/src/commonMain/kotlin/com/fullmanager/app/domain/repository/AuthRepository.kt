package com.fullmanager.app.domain.repository

import com.fullmanager.app.data.dto.login.LoginRequest
import com.fullmanager.app.domain.model.user.User
import com.fullmanager.app.domain.utils.Resource

interface AuthRepository {
    suspend fun login(credentials: LoginRequest): Resource<User>
}