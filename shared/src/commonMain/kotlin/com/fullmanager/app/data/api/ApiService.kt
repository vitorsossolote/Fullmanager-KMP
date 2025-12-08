package com.fullmanager.app.data.api

import com.fullmanager.app.data.dto.login.LoginRequest
import com.fullmanager.app.data.dto.login.LoginResponse
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.contentType

class FullmanagerApi(private val client: HttpClient){
    suspend fun login(
        credentials : LoginRequest
    ) : LoginResponse = client.post("login/validate"){
        contentType(ContentType.Application.Json)
        setBody(credentials)
    }.body<LoginResponse>()
}