package br.ufpb.care.core.users.data.remote.dto

import com.google.gson.annotations.SerializedName

data class UserRequest(
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("email") val email: String,
    @SerializedName("age") val age: Int,
    @SerializedName("password") val password: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("userTypeID") val userTypeID: String,
    @SerializedName("cpf") val cpf: String,
    @SerializedName("formID") val formID: String,
    @SerializedName("address_country") val addressCountry: String,
    @SerializedName("address_zipcode") val addressZipCode: String,
    @SerializedName("validateUser") val validateUser: ValidateUser?
)
