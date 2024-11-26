package com.itza2k.progress.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.itza2k.progress.models.Meal

@Dao
interface MealDao {
    @Query("SELECT * FROM meal")
    fun getAll(): List<Meal>

    @Insert
    fun insertAll(vararg meals: Meal)
}