package br.ufpb.care.extension

import com.google.gson.JsonParser
import retrofit2.HttpException

val Exception.httpMessage: String
    get() = if (this is HttpException) {
        val errorJsonString = this.response()?.errorBody()?.string()
        JsonParser().parse(errorJsonString).asJsonObject["message"].asString
    } else "Erro na requisição"
