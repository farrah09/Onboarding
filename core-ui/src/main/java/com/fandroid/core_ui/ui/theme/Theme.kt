package com.fandroid.core_ui.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = MediumGray,
    onPrimary = Color.White,
    secondary = LightGray,
    background = MediumGray,
    onBackground = TextWhite,
    surface = DarkGray,
    onSurface = TextWhite,
    primaryContainer = Color.White,
    onSecondary = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Color.White,
    onPrimary = Color.Black,
    secondary = LightestGray,
    background = Color.White,
    onBackground = TextWhite,
    surface = DarkGray,
    onSurface = TextWhite,
    primaryContainer = DarkBlue,
    onSecondary = Color.Black
)

@Composable
fun OnboardingAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }
    CompositionLocalProvider(LocalSpacing provides Dimensions()) {
        MaterialTheme(
            colorScheme = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}
