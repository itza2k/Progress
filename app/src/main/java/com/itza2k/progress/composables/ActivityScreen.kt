package com.itza2k.progress.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itza2k.progress.models.ActivityReading
import com.itza2k.progress.viewmodels.HealthTrackerViewModel

@Composable
fun ActivityScreen(viewModel: HealthTrackerViewModel) {
    var type by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }
    var distance by remember { mutableStateOf("") }
    var calories by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = type, onValueChange = { type = it }, label = { Text("Type") })
        TextField(value = duration, onValueChange = { duration = it }, label = { Text("Duration") })
        TextField(value = distance, onValueChange = { distance = it }, label = { Text("Distance") })
        TextField(value = calories, onValueChange = { calories = it }, label = { Text("Calories") })
        Button(onClick = {
            viewModel.addActivityReading(ActivityReading(type, duration, distance, calories))
            type = ""
            duration = ""
            distance = ""
            calories = ""
        }) {
            Text("Add Activity")
        }
        LazyColumn {
            items(viewModel.activityReadings) { reading ->
                Text("Activity - Type: ${reading.type}, Duration: ${reading.duration}, Distance: ${reading.distance}, Calories: ${reading.calories}")
            }
        }
    }
}