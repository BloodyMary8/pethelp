package com.chernikova.remote_module.entity

import Environment

import com.chernikova.remote_module.json.*
import com.google.gson.annotations.SerializedName



data class FndAnimal (
    @SerializedName("id") val id : Int? = null,
    @SerializedName("organization_id") val organization_id : String? = null,
    @SerializedName("url") val url : String? = null,
    @SerializedName("type") val type : String? = null,
    @SerializedName("species") val species : String? = null,
    @SerializedName("breeds") val breeds : Breeds? = null,
    @SerializedName("colors") val colors : Colors? = null,
    @SerializedName("age") val age : String? = null,
    @SerializedName("gender") val gender : String? = null,
    @SerializedName("size") val size : String? = null,
    @SerializedName("coat") val coat : String? = null,
    @SerializedName("attributes") val attributes : Attributes? = null,
    @SerializedName("environment") val environment : Environment? = null,
    @SerializedName("tags") val tags : List<String>? = null,
    @SerializedName("name") val name : String? = null,
    @SerializedName("description") val description : String? = null,
    @SerializedName("organization_animal_id") val organizationAnimalId : Int? = null,
    @SerializedName("photos") val photos : List<Photo> = emptyList(),
    @SerializedName("primary_photo_cropped") val primaryPhotoCropped: Photo? = null,
    //@SerializedName("videos") val videos : List<Videos>? = null,
    @SerializedName("status") val status : String? = null,
    @SerializedName("status_changed_at") val statusChangedAt: String? = null,
    @SerializedName("published_at") val published_at : String? = null,
    @SerializedName("distance") val distance : Double? = null,
    @SerializedName("contact") val contact : Contact = Contact(),
    @SerializedName("_links") val _links : Links? = null
)