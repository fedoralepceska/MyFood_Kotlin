package com.example.myfood_kotlin.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myfood_kotlin.util.Constants.Companion.FAVORITE_RECIPES_TABLE
import com.example.myfood_kotlin.models.Result

@Entity(tableName = FAVORITE_RECIPES_TABLE)
class FavoritesEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: Result
    ){

}