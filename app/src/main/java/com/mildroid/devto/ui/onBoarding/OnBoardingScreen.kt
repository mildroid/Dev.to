package com.mildroid.devto.ui.onBoarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mildroid.devto.domain.Tag
import com.mildroid.devto.ui.theme.spacing
import com.mildroid.devto.utils.toColor

@Composable
fun OnBoardingScreen(
    navigateToHomeScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Button(onClick = navigateToHomeScreen) {
            Text(text = "To Home")
        }
        Text(text = "Hello OnBoarding", fontSize = 22.sp)
    }
}