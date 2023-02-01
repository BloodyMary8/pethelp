package com.chernikova.remote_module.entity


import com.google.gson.annotations.SerializedName

data class Token(
@SerializedName("token_type")
var tokenType: String,

@SerializedName("expires_in")
var expiresIn: Int,

@SerializedName("access_token")
var accessToken: String
)