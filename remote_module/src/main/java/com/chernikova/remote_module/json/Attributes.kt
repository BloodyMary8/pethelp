package com.chernikova.remote_module.json

import com.google.gson.annotations.SerializedName

data class Attributes (

    @SerializedName("spayed_neutered") val spayed_neutered : Boolean,
    @SerializedName("house_trained") val house_trained : Boolean,
    @SerializedName("declawed") val declawed : Boolean,
    @SerializedName("special_needs") val special_needs : Boolean,
    @SerializedName("shots_current") val shots_current : Boolean
)