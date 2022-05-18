package br.ufpb.care.core.users.model

import br.ufpb.care.core.users.data.remote.dto.ValidateUser

data class User(
    val id: String = "",
    val addressCity: String = "",
    val addressCountry: String = "",
    val addressState: String = "",
    val addressZipcode: String,
    val age: Int,
    val chatAvailable: Boolean = false,
    val cpf: String,
    val createdAt: String = "",
    val `data`: String = "",
    val email: String,
    val firstName: String,
    val formID: String = "",
    val imageUrl: String = "",
    val isOnline: Boolean = false,
    val lastName: String,
    val password: String,
    val playerId: String? = "",
    val score: Int = 0,
    val userType: Type,
    val validateUser: ValidateUser? = null
)