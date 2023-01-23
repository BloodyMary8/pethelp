package com.chernikova.pethelp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chernikova.pethelp.data.entity.AnimalCard
import io.reactivex.rxjava3.core.Observable

@Dao
interface AnimalDao {
    //Запрос на всю таблицу
    @Query("SELECT * FROM cached_animals")
    fun getCachedAnimals(): Observable<List<AnimalCard>>

    //Кладём списком в БД, в случае конфликта перезаписываем
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<AnimalCard>)

}