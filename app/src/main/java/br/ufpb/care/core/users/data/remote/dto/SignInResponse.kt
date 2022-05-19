package br.ufpb.care.core.users.data.remote.dto

data class SignInResponse(
    val user: RegisterRequest,
    val token: String
)