package br.ufpb.care.core.users.data.remote.dto

data class UserDto(
    val id: String,
    val userTypeID: String,
    val email: String,
    val firstName: String,
    val lastName: String,
)