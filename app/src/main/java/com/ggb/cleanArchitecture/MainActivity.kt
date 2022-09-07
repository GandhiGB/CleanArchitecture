package com.ggb.cleanArchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.ggb.cleanArchitecture.common.graphs.RootNavigationGraph
import com.ggb.cleanArchitecture.ui.theme.CleanArchitectureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchitectureTheme {
                RootNavigationGraph(navController = rememberNavController())
            }
        }
    }
}
