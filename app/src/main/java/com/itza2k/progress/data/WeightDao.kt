package com.itza2k.progress.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.itza2k.progress.models.Weight

@Dao
interface WeightDao {
    @Query("SELECT * FROM weight")
    fun getAll(): List<Weight>

    @Insert
    fun insertAll(vararg weights: Weight)
}