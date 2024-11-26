package com.itza2k.progress.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itza2k.progress.models.WeightReading
import com.itza2k.progress.viewmodels.HealthTrackerViewModel

@Composable
fun WeightScreen(viewModel: HealthTrackerViewModel) {
    var weight by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = weight, onValueChange = { weight = it }, label = { Text("Weight") })
        Button(onClick = {
            viewModel.addWeightReading(WeightReading(weight))
            weight = ""
        }) {
            Text("Add Weight Reading")
        }
        LazyColumn {
            items(viewModel.weightReadings) { reading ->
                Text("Weight Reading - Weight: ${reading.weight}")
            }
        }
    }
}