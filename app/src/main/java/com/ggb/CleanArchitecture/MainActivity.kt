package com.ggb.CleanArchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.ggb.CleanArchitecture.common.graphs.RootNavigationGraph
import com.ggb.CleanArchitecture.ui.theme.AssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentTheme {
                RootNavigationGraph(navController = rememberNavController())
            }
        }
    }
}
