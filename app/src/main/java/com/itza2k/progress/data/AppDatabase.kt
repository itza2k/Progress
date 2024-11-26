package com.itza2k.progress.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.itza2k.progress.models.*
import com.itza2k.progress.data.*

@Database(entities = [ActivityReading::class, WaterIntake::class, SleepPattern::class, Weight::class, Meal::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun activityReadingDao(): ActivityReadingDao
    abstract fun waterIntakeDao(): WaterIntakeDao
    abstract fun sleepPatternDao(): SleepPatternDao
    abstract fun weightDao(): WeightDao
    abstract fun mealDao(): MealDao
}