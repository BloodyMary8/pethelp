package com.chernikova.remote_module.json

import com.google.gson.annotations.SerializedName

data class Colors (

    @SerializedName("primary") val primary : String? = null,
    @SerializedName("secondary") val secondary : String? = null,
    @SerializedName("tertiary") val tertiary : String? = null
)