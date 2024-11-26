package com.itza2k.progress.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.itza2k.progress.models.WaterIntake

@Dao
interface WaterIntakeDao {
    @Query("SELECT * FROM waterintake")
    fun getAll(): List<WaterIntake>

    @Insert
    fun insertAll(vararg intakes: WaterIntake)
}