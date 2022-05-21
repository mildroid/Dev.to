package com.mildroid.devto.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mildroid.devto.R

val lexendFontFamily = FontFamily(
    Font(R.font.lexend_thin, FontWeight.Thin),
    Font(R.font.lexend_semi_bold, FontWeight.SemiBold),
    Font(R.font.lexend_bold, FontWeight.Bold),
    Font(R.font.lexend_extra_bold, FontWeight.ExtraBold),
    Font(R.font.lexend_light, FontWeight.Light),
    Font(R.font.lexend_extra_light, FontWeight.ExtraLight),
    Font(R.font.lexend_medium, FontWeight.Medium),
    Font(R.font.lexend_black, FontWeight.Black),
    Font(R.font.lexend_regular)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = lexendFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    caption = TextStyle(
        fontFamily = lexendFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
    )
)