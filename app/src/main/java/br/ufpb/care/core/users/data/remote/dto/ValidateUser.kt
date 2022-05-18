package br.ufpb.care.core.users.data.remote.dto

data class ValidateUser(
    val isValidated: String,
    val userType: String,
)