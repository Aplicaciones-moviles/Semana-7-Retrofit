package facci.pm.retrofitkotlin

import com.google.gson.annotations.SerializedName

data class User (

    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("username")
    var username: String,
    @SerializedName("email")
    var email: String

)