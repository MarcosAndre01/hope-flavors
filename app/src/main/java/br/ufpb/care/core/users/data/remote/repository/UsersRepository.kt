package br.ufpb.care.core.users.data.remote.repository

import br.ufpb.care.core.users.data.remote.UsersRemoteDataSource
import br.ufpb.care.core.users.data.remote.dto.UserRequest
import br.ufpb.care.core.users.data.remote.dto.ValidateUser
import br.ufpb.care.core.users.model.User
import com.google.gson.annotations.SerializedName

class UsersRepository(private val usersRemoteDataSource: UsersRemoteDataSource) {
    suspend fun register(user: User) {
        usersRemoteDataSource.register(user.toUserDto())
    }

    suspend fun signIn(user: User) {
        usersRemoteDataSource.signIn(user.toUserDto())
    }
}

private fun User.toUserDto() : UserRequest {
    return UserRequest(
        firstName,
        lastName,
        email,
        age,
        password,
        imageUrl,
        userTypeID = userType.name,
        cpf,
        formID,
        addressCountry,
        addressZipCode = addressZipcode,
        validateUser = validateUser
    )
}