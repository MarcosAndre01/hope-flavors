package br.ufpb.care.core.users.data

import br.ufpb.care.core.users.data.remote.UsersRemoteDataSource
import br.ufpb.care.core.users.data.remote.dto.RegisterRequest
import br.ufpb.care.core.users.data.remote.dto.ValidateUser
import br.ufpb.care.core.users.model.UserDetailsForm
import br.ufpb.care.core.users.model.UserType

class UsersRepository(private val usersRemoteDataSource: UsersRemoteDataSource) {
    suspend fun register(detailsForm: UserDetailsForm, type: UserType) {
        val request = RegisterRequest(
            addressCountry = "",
            addressZipcode = detailsForm.addressZipcode,
            age = detailsForm.age,
            cpf = detailsForm.cpf,
            email = detailsForm.email,
            firstName = detailsForm.firstName,
            imageUrl = "",
            lastName = detailsForm.lastName,
            password = detailsForm.password,
            userTypeID = type.name,
            validateUser = ValidateUser(isValidated = "Pendente", userType = type.name)
        )

        usersRemoteDataSource.register(request)
    }

//    suspend fun signIn(user: User) {
//        usersRemoteDataSource.signIn(user.toUserDto())
//    }
}
