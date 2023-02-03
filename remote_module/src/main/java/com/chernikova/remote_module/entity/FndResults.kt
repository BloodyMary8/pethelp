package com.chernikova.remote_module.entity


import com.google.gson.annotations.SerializedName

data class FndResults(
    @SerializedName("count_per_page")
    val countPerPage: Int,
    @SerializedName("results")
    val fndAnimal: List<FndAnimal>,
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)