package com.chernikova.remote_module.entity


import com.chernikova.remote_module.json.Pagination
import com.google.gson.annotations.SerializedName

data class FndResults(
    @SerializedName("results")
    val fndAnimal: List<FndAnimal>? = null,
    @SerializedName("pagination")
    val pagination: Pagination? = null
)