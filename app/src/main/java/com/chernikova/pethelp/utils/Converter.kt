package com.chernikova.pethelp.utils

import com.chernikova.pethelp.data.entity.AnimalCard
import com.chernikova.remote_module.entity.FndAnimal


object Converter {
    @JvmStatic
    fun convertApiListToDtoList(list: List<FndAnimal>): List<AnimalCard> {
        val result = mutableListOf<AnimalCard>()
        list?.forEach {
            result.add(AnimalCard(
                name = it.name,
                poster = it.photos,
                description = it.description
            ))
        }
        return result
    }
}