package com.kieling.whitescreen.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val darkColorPalette = darkColorScheme(
    primary = White,
    secondary = Teal200
)

private val lightColorPalette = lightColorScheme(
    primary = White,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun WhiteScreenTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        darkColorPalette
    } else {
        lightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}
