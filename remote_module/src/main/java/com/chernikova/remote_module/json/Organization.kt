package com.chernikova.remote_module.json

import com.google.gson.annotations.SerializedName

data class Organization (
    @SerializedName("href") val href: String? = null
)