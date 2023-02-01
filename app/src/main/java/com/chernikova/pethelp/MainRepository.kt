package com.chernikova.pethelp

import com.chernikova.pethelp.data.dao.AnimalDao
import com.chernikova.pethelp.data.entity.AnimalCard
import io.reactivex.rxjava3.core.Observable

class MainRepository(private val AnimalDao: AnimalDao) {

    fun putToDb(animals: List<AnimalCard>) {
        AnimalDao.insertAll(animals)
    }

    fun getAllFromDB(): Observable<List<AnimalCard>> = AnimalDao.getCachedAnimals()
}