package com.example.myfood_kotlin.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myfood_kotlin.models.FoodRecipe
import com.example.myfood_kotlin.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(var foodRecipe: FoodRecipe) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}