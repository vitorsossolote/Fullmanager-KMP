package com.fullmanager.app.domain.utils

import kotlinx.coroutines.CancellationException

sealed class Resource<out T: Any> {
    data object Loading: Resource<Nothing>()
    data class Success<out T: Any>(val data: T) : Resource<T>()
    data class Error(val error: AppError): Resource<Nothing>()
}

sealed class AppError(open val message: String, open val cause: Throwable? = null){
    data class ApiError(override val message: String, val code: Int? = null, override val cause: Throwable?= null): AppError(message,cause)
    data class NetworkError(override val message: String = "Sem conexão", override val cause: Throwable? = null): AppError(message,cause)
    data class DomainError(override val message: String, val details: String? = null): AppError(message)
    data class ValidationError(override val message: String, val field: String? = null): AppError(message)
    data class EmptyBody(override val message: String = "Resposta vazia"): AppError(message)
    data class NotFound(override val message: String = "Não encontrado", override val cause: Throwable? = null): AppError(message,cause)
    data class Unauthorized(override val message: String = "Não autorizado", override val cause: Throwable? = null): AppError(message,cause)
    data class Unknown(override val message: String = "Erro desconhecido", override val cause: Throwable?= null): AppError(message, cause)
}

