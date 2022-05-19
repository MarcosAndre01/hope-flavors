package br.ufpb.care.core.users.data.remote

import br.ufpb.care.core.users.data.remote.dto.RegisterRequest
import br.ufpb.care.core.users.data.remote.dto.SignInResponse

interface UsersRemoteDataSource {
    suspend fun register(user: RegisterRequest): SignInResponse
    suspend fun signIn(user: RegisterRequest): SignInResponse
}