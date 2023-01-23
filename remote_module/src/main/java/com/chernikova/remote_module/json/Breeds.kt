package com.chernikova.remote_module.json

import com.google.gson.annotations.SerializedName

data class Breeds (

    @SerializedName("primary") val primary : String,
    @SerializedName("secondary") val secondary : String,
    @SerializedName("mixed") val mixed : Boolean,
    @SerializedName("unknown") val unknown : Boolean
)