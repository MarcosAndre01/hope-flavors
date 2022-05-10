package br.ufpb.care.core.users.data.remote

import br.ufpb.care.core.users.data.remote.dto.SignInResponse
import br.ufpb.care.core.users.data.remote.dto.UserDto

interface UsersRemoteDataSource {
    suspend fun register(user: UserDto): SignInResponse
    suspend fun signIn(user: UserDto): SignInResponse
}