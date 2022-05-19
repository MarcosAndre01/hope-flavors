package br.ufpb.care.core.users.data.remote

import android.util.Log
import br.ufpb.care.core.users.data.remote.dto.RegisterRequest
import br.ufpb.care.core.users.data.remote.dto.SignInResponse

private const val TAG = "UsersFakeDataSource"
class UsersFakeDataSource : UsersRemoteDataSource {
    private var users = listOf<RegisterRequest>()

    override suspend fun register(user: RegisterRequest): SignInResponse {
        users = users.plus(user)

        Log.d(TAG, "register: $user")

        return SignInResponse(user, "token")
    }

    override suspend fun signIn(user: RegisterRequest): SignInResponse {
        return SignInResponse(user, "token")
    }
}