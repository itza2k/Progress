package com.itza2k.progress.viewmodels

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import com.itza2k.progress.models.*

class HealthTrackerViewModel : ViewModel() {
    val activityReadings = mutableStateListOf<ActivityReading>()
    val waterIntakes = mutableStateListOf<WaterIntake>()
    val sleepPatterns = mutableStateListOf<SleepPattern>()
    val weights = mutableStateListOf<Weight>()
    val meals = mutableStateListOf<Meal>()

    fun addActivityReading(reading: ActivityReading) {
        activityReadings.add(reading)
    }

    fun addWaterIntake(intake: WaterIntake) {
        waterIntakes.add(intake)
    }

    fun addSleepPattern(pattern: SleepPattern) {
        sleepPatterns.add(pattern)
    }

    fun addWeight(weight: Weight) {
        weights.add(weight)
    }

    fun addMeal(meal: Meal) {
        meals.add(meal)
    }
}