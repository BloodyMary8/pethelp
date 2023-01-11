package com.chernikova.pethelp.utils

import com.chernikova.pethelp.data.entity.AnimalCard



object Converter {
    @JvmStatic
    fun convertApiListToDtoList(list: List<com.chernikova.remote_module.entity.FndAnimal>?): List<AnimalCard> {
        val result = mutableListOf<AnimalCard>()
        list?.forEach {
            result.add(AnimalCard(
              name = it.name,
                photos = it.photos,
                description = it.description
            ))
        }
        return result
    }
}