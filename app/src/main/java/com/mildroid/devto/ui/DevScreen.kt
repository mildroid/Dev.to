package com.mildroid.devto.ui

sealed class DevScreen(val route: String) {

    object Home: DevScreen("dev_home_screen")
    object OnBoarding: DevScreen("dev_onBoarding_screen")
}
