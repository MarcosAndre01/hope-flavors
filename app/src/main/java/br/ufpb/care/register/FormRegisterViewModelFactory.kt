package br.ufpb.care.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.ufpb.care.core.users.data.UsersRepository

class FormRegisterViewModelFactory(
    private val usersRepository: UsersRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass == FormRegisterViewModelImp::class.java) {
            FormRegisterViewModelImp(usersRepository) as T
        } else {
            super.create(modelClass)
        }
    }
}