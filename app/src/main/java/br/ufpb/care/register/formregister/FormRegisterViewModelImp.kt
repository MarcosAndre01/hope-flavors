package br.ufpb.care.register.formregister

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.ufpb.care.core.users.data.remote.repository.UsersRepository
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