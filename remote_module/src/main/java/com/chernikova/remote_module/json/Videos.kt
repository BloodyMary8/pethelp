package com.chernikova.remote_module.json

import com.google.gson.annotations.SerializedName

data class Videos (

    @SerializedName("embed") val embed : String
)