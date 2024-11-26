package com.itza2k.progress.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itza2k.progress.models.Meal
import com.itza2k.progress.viewmodels.HealthTrackerViewModel

@Composable
fun MealScreen(viewModel: HealthTrackerViewModel) {
    var mealName by remember { mutableStateOf("") }
    var calories by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = mealName, onValueChange = { mealName = it }, label = { Text("Meal Name") })
        TextField(value = calories, onValueChange = { calories = it }, label = { Text("Calories") })
        Button(onClick = {
            viewModel.addMeal(Meal(mealName, calories))
            mealName = ""
            calories = ""
        }) {
            Text("Add Meal")
        }
        LazyColumn {
            items(viewModel.meals) { meal ->
                Text("Meal - Name: ${meal.name}, Calories: ${meal.calories}")
            }
        }
    }
}