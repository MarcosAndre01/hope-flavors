package br.ufpb.care.register.model

data class UserDetails(
    val addressZipCode: String,
    val cpf: String,
    val age: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
)
