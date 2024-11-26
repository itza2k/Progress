package com.itza2k.progress.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.itza2k.progress.models.ActivityReading

@Dao
interface ActivityReadingDao {
    @Query("SELECT * FROM activityreading")
    fun getAll(): List<ActivityReading>

    @Insert
    fun insertAll(vararg readings: ActivityReading)
}