package br.ufpb.care.core.users.data.remote

import android.util.Log
import br.ufpb.care.core.retrofit
import br.ufpb.care.core.users.data.remote.dto.RegisterRequest
import br.ufpb.care.core.users.data.remote.dto.SignInResponse
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

private const val TAG = "UsersRemoteDataSource"
object UsersRemoteDataSource {
    suspend fun register(user: RegisterRequest): SignInResponse {
        Log.d(TAG, "register: chamou service")
        val ret = service.register(user)
        return ret
    }
    suspend fun signIn(email: String, password: String): SignInResponse = service.signIn(email, password)
}

val service: UsersService by lazy {
    retrofit.create(UsersService::class.java)
}

interface UsersService {
    @POST("/users/register")
    suspend fun register(@Body userData: RegisterRequest): SignInResponse

    @POST("/users/authenticate")
    suspend fun signIn(
        @Field("email") email: String,
        @Field("password") password: String
    ): SignInResponse
}