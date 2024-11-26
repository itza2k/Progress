package com.itza2k.progress.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.itza2k.progress.models.SleepPattern

@Dao
interface SleepPatternDao {
    @Query("SELECT * FROM sleeppattern")
    fun getAll(): List<SleepPattern>

    @Insert
    fun insertAll(vararg patterns: SleepPattern)
}