package com.chernikova.remote_module.json

import com.google.gson.annotations.SerializedName

data class Token(
    @SerializedName("token_type") val tokenType : String,
    @SerializedName("expires_in") val expiresIn : Int,
    @SerializedName("access_token") val accessToken : String
)
