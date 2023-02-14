package com.chernikova.pethelp.utils

import com.chernikova.pethelp.data.entity.AnimalCard
import com.chernikova.remote_module.entity.FndAnimal


object Converter {
    @JvmStatic
    fun convertApiListToDtoList(list: List<FndAnimal>?): List<AnimalCard> {
        val result = mutableListOf<AnimalCard>()
        list?.forEach {
            result.add(AnimalCard(
                title = it.name,
                poster = it.primaryPhotoCropped?.medium,
                description = it.description,
                        isInFavorites = false

            ))
        }
        return result
    }
}