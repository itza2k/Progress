package com.itza2k.progress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.itza2k.progress.ui.theme.ProgressTheme
import com.itza2k.progress.viewmodels.HealthTrackerViewModel
import com.itza2k.progress.composables.HealthTracker

class MainActivity : ComponentActivity() {
    private val viewModel: HealthTrackerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProgressTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HealthTracker(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}