package com.ggb.cleanArchitecture.feature_security.presentation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ggb.cleanArchitecture.common.graphs.Graph
import com.ggb.cleanArchitecture.feature_security.presentation.login.LoginScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                }
            )
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
}