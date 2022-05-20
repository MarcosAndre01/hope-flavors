package br.ufpb.care.core.users.data

import android.util.Log
import br.ufpb.care.core.retrofit
import br.ufpb.care.core.users.data.remote.UsersRemoteDataSource
import br.ufpb.care.core.users.data.remote.dto.RegisterRequest
import br.ufpb.care.core.users.data.remote.dto.SignInResponse
import br.ufpb.care.core.users.data.remote.dto.ValidateUser
import br.ufpb.care.core.users.model.ApiState
import br.ufpb.care.core.users.model.UserDetailsForm
import br.ufpb.care.core.users.model.UserType
import br.ufpb.care.extension.httpMessage
import retrofit2.HttpException

private const val TAG = "UsersRepository"
class UsersRepository(private val usersRemoteDataSource: UsersRemoteDataSource = UsersRemoteDataSource) {
    suspend fun register(detailsForm: UserDetailsForm, type: UserType): ApiState<SignInResponse> {
        val request = RegisterRequest(
            addressCountry = "Brasil",
            addressZipcode = detailsForm.addressZipcode,
            age = detailsForm.age,
            cpf = detailsForm.cpf,
            email = detailsForm.email,
            firstName = detailsForm.firstName,
            imageUrl = "https://projecthope1.s3.amazonaws.com/no_user.png",
            lastName = detailsForm.lastName,
            password = detailsForm.password,
            userTypeID = type.name,
            validateUser = ValidateUser(isValidated = "Pendente", userType = type.name)
        )

        return try {
            Log.d(TAG, "register: success")
            ApiState.Success(usersRemoteDataSource.register(request))
        } catch(e: HttpException) {
            Log.d(TAG, "register: failed")
            ApiState.Failed(e.httpMessage)
        }
    }

//    suspend fun signIn(user: User) {
//        usersRemoteDataSource.signIn(user.toUserDto())
//    }
}
