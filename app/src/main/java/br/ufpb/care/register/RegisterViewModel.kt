package br.ufpb.care.register

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.ufpb.care.core.users.data.UsersRepository
import br.ufpb.care.core.users.data.remote.UsersFakeDataSource
import br.ufpb.care.core.users.model.UserDetailsForm
import br.ufpb.care.register.model.UserKind
import kotlinx.coroutines.launch

private const val TAG = "RegisterViewModel"

class RegisterViewModel(
    private val userRepository: UsersRepository = UsersRepository(
        UsersFakeDataSource()
    )
) : ViewModel() {
    private lateinit var selectedUserKind: UserKind

    fun selectUserKind(kind: UserKind) {
        selectedUserKind = kind
        Log.d(TAG, "selectUserKind: $selectedUserKind")
    }

    fun submitUserDetails(userDetails: UserDetailsForm) {
        Log.d(TAG, "submitUserDetails: $userDetails")
        viewModelScope.launch {
            userRepository.register(
                userDetails, UserTypeConverterImpl.fromUserKind(selectedUserKind)
            )
        }

    }
}