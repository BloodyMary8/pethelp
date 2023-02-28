package com.chernikova.remote_module.json
import com.google.gson.annotations.SerializedName

data class Contact(
    @SerializedName("address") val address : Address = Address(),
    @SerializedName("email") val email : String? = null,
    @SerializedName("phone") val phone : String? = null

)