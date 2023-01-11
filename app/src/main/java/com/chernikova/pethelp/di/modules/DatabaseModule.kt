package com.chernikova.pethelp.di.modules

import android.content.Context
import androidx.room.Room
import com.chernikova.pethelp.MainRepository
import com.chernikova.pethelp.data.dao.AnimalDao
import com.chernikova.pethelp.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAnimalDao(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "animal_db"
        ).build().animalDao()

    @Provides
    @Singleton
    fun provideRepository(animalDao: AnimalDao) = MainRepository(animalDao)
}