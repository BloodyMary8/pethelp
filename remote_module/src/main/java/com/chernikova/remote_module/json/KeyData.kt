package com.chernikova.remote_module.json

import com.google.gson.annotations.SerializedName

data class KeyData(
    @SerializedName("grant_type") val grantType: String,
    @SerializedName("client_id") val clientId : String,
    @SerializedName("client_secret") val clientSecret : String
)