package com.fullmanager.app.data.mapper.login

import com.fullmanager.app.data.dto.login.LoginResponse
import com.fullmanager.app.domain.model.user.User

fun LoginResponse.toDomain(): User {
    val result = this.data!!.result
    return User(
        id = result.id_usuario.toInt(),
        name = result.nome_usuario,
        email = result.email_usuario
    )
}