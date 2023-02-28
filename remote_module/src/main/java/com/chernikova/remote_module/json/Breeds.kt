package com.chernikova.remote_module.json

import com.google.gson.annotations.SerializedName

data class Breeds (

    @SerializedName("primary") val primary : String? = null,
    @SerializedName("secondary") val secondary : String? = null,
    @SerializedName("mixed") val mixed : Boolean? = null,
    @SerializedName("unknown") val unknown : Boolean? = null
)