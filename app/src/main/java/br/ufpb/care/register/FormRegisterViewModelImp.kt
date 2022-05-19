package br.ufpb.care.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.ufpb.care.core.users.data.UsersRepository
import br.ufpb.care.core.users.model.Type
import br.ufpb.care.core.users.model.User
import kotlinx.coroutines.launch

class FormRegisterViewModelImp(
    val usersRepository: UsersRepository
): ViewModel() {


    fun submitUserDetails(mUser: User){
        viewModelScope.launch {
            usersRepository.register(mUser)
        }
    }
}