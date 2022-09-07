package com.ggb.cleanArchitecture.feature_page.presentation.graphs

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ggb.cleanArchitecture.common.graphs.Graph
import com.ggb.cleanArchitecture.feature_page.presentation.screens.BottomNavScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomNavScreen.Home.route
    ) {
        composable(route = BottomNavScreen.Home.route) {

        }

        composable(route = BottomNavScreen.Magneds.route) {
            AndroidView(factory = {
                WebView(it).apply{
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()
                    loadUrl("https://magneds.com/")
                }
            },
                update = {
                    it.loadUrl("https://magneds.com/")
                }
            )
        }
    }
}

