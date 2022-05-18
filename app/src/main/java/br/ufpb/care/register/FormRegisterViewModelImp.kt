package br.ufpb.care.register

import androidx.lifecycle.ViewModel
import br.ufpb.care.core.users.data.UsersRepository
import br.ufpb.care.core.users.model.User

class FormRegisterViewModelImp(
    val usersRepository: UsersRepository
): ViewModel() {

    suspend fun submitUserDetails(user: User){
        usersRepository.register(user)
    }
}