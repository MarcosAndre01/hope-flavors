package br.ufpb.care.register

import android.util.Log
import androidx.lifecycle.ViewModel
import br.ufpb.care.core.users.data.remote.UsersFakeDataSource
import br.ufpb.care.core.users.data.remote.repository.UsersRepository
import br.ufpb.care.register.model.UserDetails
import br.ufpb.care.register.model.UserKind

private const val TAG = "RegisterViewModel"

class RegisterViewModel(
    private val repository: UsersRepository = UsersRepository(
        UsersFakeDataSource()
    )
) : ViewModel() {
    private lateinit var selectedUserKind: UserKind

    fun selectUserKind(kind: UserKind) {
        selectedUserKind = kind
        Log.d(TAG, "selectUserKind: ${selectedUserKind}")
    }

    fun submitUserDetails(userDetails: UserDetails) {

    }
}