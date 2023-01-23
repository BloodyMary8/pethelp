package com.chernikova.remote_module.json
import com.google.gson.annotations.SerializedName

data class _links (
    @SerializedName("self") val self : String,
    @SerializedName("type") val type : String,
    @SerializedName("organization") val organization : String
)