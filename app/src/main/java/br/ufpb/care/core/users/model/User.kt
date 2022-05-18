package br.ufpb.care.core.users.model

data class User(
    val id: String,
    val type: Type,
    val email: String,
    val firstName: String,
    val lastName: String,
) {
    class Type(val name: String)
}
