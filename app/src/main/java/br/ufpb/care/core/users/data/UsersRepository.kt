package br.ufpb.care.core.users.data

import br.ufpb.care.core.users.data.remote.UsersRemoteDataSource
import br.ufpb.care.core.users.data.remote.dto.UserDto
import br.ufpb.care.core.users.model.User

class UsersRepository(private val usersRemoteDataSource: UsersRemoteDataSource) {
    suspend fun register(user: User) {
        usersRemoteDataSource.register(user.toUserDto())
    }

    suspend fun signIn(user: User) {
        usersRemoteDataSource.signIn(user.toUserDto())
    }
}

private fun User.toUserDto() : UserDto {
    return UserDto(
        id = id,
        userTypeID = type.name,
        email = email,
        firstName = firstName,
        lastName = lastName,
    )
}