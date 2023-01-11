package com.chernikova.remote_module.entity


import com.google.gson.annotations.SerializedName

data class FndResults(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val fndAnimal: List<FndAnimal>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)