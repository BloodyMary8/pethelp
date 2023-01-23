package com.chernikova.remote_module.entity

import Environment
import com.chernikova.remote_module.json.*
import com.google.gson.annotations.SerializedName



data class FndAnimal (
    @SerializedName("id") val id : Int,
    @SerializedName("organization_id") val organization_id : String,
    @SerializedName("url") val url : String,
    @SerializedName("type") val type : String,
    @SerializedName("species") val species : String,
    @SerializedName("breeds") val breeds : Breeds,
    @SerializedName("colors") val colors : Colors,
    @SerializedName("age") val age : String,
    @SerializedName("gender") val gender : String,
    @SerializedName("size") val size : String,
    @SerializedName("coat") val coat : String,
    @SerializedName("name") val name : String,
    @SerializedName("description") val description : String,
    @SerializedName("photos") val photos : String,
    @SerializedName("videos") val videos : List<Videos>,
    @SerializedName("status") val status : String,
    @SerializedName("attributes") val attributes : Attributes,
    @SerializedName("environment") val environment : Environment,
    @SerializedName("tags") val tags : List<String>,
    @SerializedName("contact") val contact : Contact,
    @SerializedName("published_at") val published_at : String,
    @SerializedName("distance") val distance : String,
    @SerializedName("_links") val _links : _links
)

