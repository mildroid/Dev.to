package com.mildroid.devto.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.mildroid.devto.ui.DevApp
import com.mildroid.devto.ui.theme.*
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.material.MaterialTheme as material

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

/*
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.notReadyYet.value
            }
        }
*/

        setContent {
            DevTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = material.colors.background
                ) {
                    val navController = rememberNavController()

                    DevApp(navController = navController)
                }
            }
        }
    }
}