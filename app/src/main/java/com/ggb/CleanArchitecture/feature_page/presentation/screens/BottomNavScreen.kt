package com.ggb.CleanArchitecture.feature_page.presentation.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home : BottomNavScreen(
        route = "HOME",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Magneds : BottomNavScreen(
        route = "MAGNEDS",
        title = "Magneds",
        icon = Icons.Default.ArrowForward
    )

}
