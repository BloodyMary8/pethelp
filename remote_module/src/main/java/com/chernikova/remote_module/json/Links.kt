package com.chernikova.remote_module.json
import com.google.gson.annotations.SerializedName

data class Links (
    @SerializedName("self") val self : Self? = null,
    @SerializedName("type") val type : Type? = null,
    @SerializedName("organization") val organization : Organization? = null
)