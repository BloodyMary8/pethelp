package com.chernikova.remote_module.json
import com.google.gson.annotations.SerializedName

data class Contact (

    @SerializedName("email") val email : String,
    @SerializedName("phone") val phone : String,
    @SerializedName("address") val address : String
)