package com.fullmanager.app.data.dto.login

@kotlinx.serialization.Serializable
data class LoginResponse(
    val status: Boolean,
    val message: String? = null,
    val error: String? = null,
    val data: LoginDataWrapper? = null,
)

@kotlinx.serialization.Serializable
data class LoginDataWrapper(
    val status: Boolean,
    val message: String,
    val result: LoginDataResponse
)

@kotlinx.serialization.Serializable
data class LoginDataResponse(
    val id_usuario: String,
    val nome_usuario: String,
    val email_usuario: String
)


@kotlinx.serialization.Serializable
data class LoginRequest(
    val username: String,
    val password: String,
    val isMobile: Int = 1
)