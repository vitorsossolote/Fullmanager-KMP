package com.fullmanager.app.data.mapper.login

import com.fullmanager.app.data.dto.login.LoginResponse
import com.fullmanager.app.domain.model.user.User

fun LoginResponse.toDomain(): User {
    val mappedUser = User(
        id = this.data.id_usuario.toInt(),
        name = this.data.nome_usuario,
        email = this.data.email_usuario
    )

    return mappedUser
}