package br.ufpb.care.core.users.model

data class UserDetailsForm(
    val addressZipcode: String,
    val cpf: String,
    val age: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
)
