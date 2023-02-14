package com.chernikova.remote_module.json

import com.google.gson.annotations.SerializedName

data class Photo (
    @SerializedName("small") val small : String,
    @SerializedName("medium") val medium : String,
    @SerializedName("large") val large : String,
    @SerializedName("full") val full : String
)