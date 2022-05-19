package br.ufpb.care.core.users.data.remote.dto


import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("address_country")
    val addressCountry: String,
    @SerializedName("address_zipcode")
    val addressZipcode: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("cpf")
    val cpf: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("userTypeID")
    val userTypeID: String,
    @SerializedName("validateUser")
    val validateUser: ValidateUser
)