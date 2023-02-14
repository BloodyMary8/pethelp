package com.chernikova.remote_module.json

import com.google.gson.annotations.SerializedName

data class Attributes (

    @SerializedName("spayed_neutered") val spayed_neutered : Boolean? = null,
    @SerializedName("house_trained") val house_trained : Boolean? = null,
    @SerializedName("declawed") val declawed : Boolean? = null,
    @SerializedName("special_needs") val special_needs : Boolean? = null,
    @SerializedName("shots_current") val shots_current : Boolean? = null
)