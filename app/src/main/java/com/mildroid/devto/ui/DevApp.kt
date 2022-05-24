package com.mildroid.devto.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mildroid.devto.ui.home.HomeScreen
import com.mildroid.devto.ui.onBoarding.OnBoardingScreen

@Composable
fun DevApp(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = DevScreen.OnBoarding.route
    ) {
        composable(
            route = DevScreen.Home.route
        ) {
            HomeScreen()
        }

        composable(
            route = DevScreen.OnBoarding.route
        ) {
            OnBoardingScreen {
                navController.run {
                    popBackStack()
                    navigate(route = DevScreen.Home.route)
                }
            }
        }
    }
}