package com.chernikova.remote_module.json

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("address1") val address1 : String? = null,
    @SerializedName("address2") val address2 : String? = null,
    @SerializedName("city") val city : String = "N/A",
    @SerializedName("state") val state : String? = null,
    @SerializedName("postcode") val postcode : String? = null,
    @SerializedName("country") val country : String? = null,
)