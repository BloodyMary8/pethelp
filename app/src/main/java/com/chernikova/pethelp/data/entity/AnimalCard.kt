package com.chernikova.pethelp.data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "cached_animals")

data class AnimalCard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "animal_name") val name: String,
    @ColumnInfo(name = "poster") val poster: String?, //У нас будет приходить ссылка на картинку, так что теперь это String
    @ColumnInfo(name = "description") val description: String,
        //var isInFavorites: Boolean = false
    ) : Parcelable
