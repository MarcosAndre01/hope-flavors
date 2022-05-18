package br.ufpb.care.core.users.data.remote

import br.ufpb.care.core.users.data.remote.dto.SignInResponse
import br.ufpb.care.core.users.data.remote.dto.UserRequest

interface UsersRemoteDataSource {
    suspend fun register(user: UserRequest): SignInResponse
    suspend fun signIn(user: UserRequest): SignInResponse
}