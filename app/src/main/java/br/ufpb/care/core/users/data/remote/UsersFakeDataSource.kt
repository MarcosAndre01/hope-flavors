package br.ufpb.care.core.users.data.remote

import br.ufpb.care.core.users.data.remote.dto.SignInResponse
import br.ufpb.care.core.users.data.remote.dto.UserDto

class UsersFakeDataSource : UsersRemoteDataSource {
    private var users = listOf<UserDto>()

    override suspend fun register(user: UserDto): SignInResponse {
        users = users.plus(user)

        return SignInResponse(user, "token")
    }

    override suspend fun signIn(user: UserDto): SignInResponse {
        return SignInResponse(user, "token")
    }
}