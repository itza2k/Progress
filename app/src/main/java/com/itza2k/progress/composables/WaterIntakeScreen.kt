package com.itza2k.progress.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.itza2k.progress.models.WaterIntake
import com.itza2k.progress.viewmodels.HealthTrackerViewModel

@Composable
fun WaterIntakeScreen(viewModel: HealthTrackerViewModel) {
    var amount by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = amount, onValueChange = { amount = it }, label = { Text("Amount (ml)") })
        Button(onClick = {
            viewModel.addWaterIntake(WaterIntake(amount))
            amount = ""
        }) {
            Text("Add Water Intake")
        }
        LazyColumn {
            items(viewModel.waterIntakes) { intake ->
                Text("Water Intake - Amount: ${intake.amount} ml")
            }
        }
    }
}