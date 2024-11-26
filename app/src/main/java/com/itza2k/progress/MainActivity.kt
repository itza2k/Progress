package com.itza2k.progress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.itza2k.progress.ui.theme.ProgressTheme
import com.itza2k.progress.viewmodels.HealthTrackerViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val viewModel: HealthTrackerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProgressTheme {
                MainScreen(viewModel)
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: HealthTrackerViewModel) {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.FitnessCenter, contentDescription = "Activity") },
                    label = { Text("Activity") },
                    selected = false,
                    onClick = { navController.navigate("activity") }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.LocalDrink, contentDescription = "Water") },
                    label = { Text("Water") },
                    selected = false,
                    onClick = { navController.navigate("water") }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Bedtime, contentDescription = "Sleep") },
                    label = { Text("Sleep") },
                    selected = false,
                    onClick = { navController.navigate("sleep") }
                )
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = "activity", Modifier.padding(innerPadding)) {
            composable("activity") { ActivityScreen(viewModel) }
            composable("water") { WaterIntakeScreen(viewModel) }
            composable("sleep") { SleepPatternScreen(viewModel) }
        }
    }
}