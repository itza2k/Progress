package com.itza2k.progress.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itza2k.progress.models.SleepPattern
import com.itza2k.progress.viewmodels.HealthTrackerViewModel

@Composable
fun SleepPatternScreen(viewModel: HealthTrackerViewModel) {
    var hours by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = hours, onValueChange = { hours = it }, label = { Text("Hours") })
        Button(onClick = {
            viewModel.addSleepPattern(SleepPattern(hours))
            hours = ""
        }) {
            Text("Add Sleep Pattern")
        }
        LazyColumn {
            items(viewModel.sleepPatterns) { pattern ->
                Text("Sleep Pattern - Hours: ${pattern.hours}")
            }
        }
    }
}