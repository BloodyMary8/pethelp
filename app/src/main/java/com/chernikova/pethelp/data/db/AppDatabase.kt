package com.chernikova.pethelp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chernikova.pethelp.data.entity.AnimalCard
import com.chernikova.pethelp.data.dao.AnimalDao

@Database(entities = [AnimalCard::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun animalDao(): AnimalDao
}