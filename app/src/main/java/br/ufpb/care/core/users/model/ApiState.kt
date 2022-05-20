package br.ufpb.care.core.users.model

sealed class ApiState<T> {
    class Success<T>(val data: T) : ApiState<T>()
    class Loading<T> : ApiState<T>()
    class Failed<T>(val message: String) : ApiState<T>()
    class Initial<T> : ApiState<T>()
}
