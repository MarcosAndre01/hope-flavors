package br.ufpb.care.core.users.model

sealed class ApiState{

    object Succes : ApiState()
    object Loading : ApiState()
    object Failed : ApiState()
    object Initial : ApiState()
}
