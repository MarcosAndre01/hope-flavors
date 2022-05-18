package br.ufpb.care.core.users.data.remote

import br.ufpb.care.core.users.data.remote.dto.SignInResponse
import br.ufpb.care.core.users.data.remote.dto.UserRequest

class UsersFakeDataSource : UsersRemoteDataSource {
    private var users = listOf<UserRequest>()

    override suspend fun register(user: UserRequest): SignInResponse {
        users = users.plus(user)

        return SignInResponse(user, "token")
    }

    override suspend fun signIn(user: UserRequest): SignInResponse {
        return SignInResponse(user, "token")
    }
}