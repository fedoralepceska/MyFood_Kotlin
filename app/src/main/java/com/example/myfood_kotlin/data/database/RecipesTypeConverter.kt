package com.example.myfood_kotlin.data.database

import androidx.room.TypeConverter
import com.example.myfood_kotlin.models.FoodRecipe
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RecipesTypeConverter {

    var gson = Gson()

    @TypeConverter
    fun foodRecipeToString(foodRecipe: FoodRecipe): String {
        return gson.toJson(foodRecipe)
    }

    @TypeConverter
    fun stringToFoodRecipe(data: String): FoodRecipe {
        val listType = object : TypeToken<FoodRecipe>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun resultToString(result: com.example.myfood_kotlin.models.Result): String {
        return gson.toJson(result)
    }

    @TypeConverter
    fun stringToResult(string: String): com.example.myfood_kotlin.models.Result {
        val listType = object : TypeToken<com.example.myfood_kotlin.models.Result>() {}.type
        return gson.fromJson(string, listType)
    }
}