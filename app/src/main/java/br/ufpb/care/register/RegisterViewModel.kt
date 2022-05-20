package br.ufpb.care.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.ufpb.care.core.users.data.UsersRepository
import br.ufpb.care.core.users.data.remote.UsersFakeDataSource
import br.ufpb.care.core.users.data.remote.UsersRemoteDataSource
import br.ufpb.care.core.users.data.remote.dto.SignInResponse
import br.ufpb.care.core.users.model.ApiState
import br.ufpb.care.core.users.model.UserDetailsForm
import br.ufpb.care.register.model.UserKind
import kotlinx.coroutines.launch

private const val TAG = "RegisterViewModel"

class RegisterViewModel(
    private val userRepository: UsersRepository = UsersRepository(
        UsersRemoteDataSource
    )
) : ViewModel() {
    private lateinit var selectedUserKind: UserKind

    private val _registerResponse: MutableLiveData<ApiState<SignInResponse>> = MutableLiveData()
    val registerResponse: LiveData<ApiState<SignInResponse>>
        get() = _registerResponse


    fun selectUserKind(kind: UserKind) {
        selectedUserKind = kind
        Log.d(TAG, "selectUserKind: $selectedUserKind")
    }

    fun submitUserDetails(userDetails: UserDetailsForm) {
        Log.d(TAG, "submitUserDetails: $userDetails")
        viewModelScope.launch {
            _registerResponse.value = userRepository.register(
                userDetails, UserTypeConverterImpl.fromUserKind(selectedUserKind)
            )
        }

    }
}