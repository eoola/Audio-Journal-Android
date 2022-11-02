package com.wpi.audiojournal.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color


private val DarkColorPalette = darkColors(
    primary = Blue,
    primaryVariant = Purple,
    secondary = Salmon
)

private val LightColorPalette = lightColors(
    primary = Blue,
    primaryVariant = Purple,
    secondary = Salmon
)

data class ColorScheme(val colors: List<Color>, val background: Color, val content: Color, val borders: Color) {
    fun getRainbowColor(index: Int) = colors[index % colors.size]
}



val LocalColorScheme = compositionLocalOf {
    ColorScheme(
        listOf(Purple, Salmon, Orange, Teal, Yellow, Blue),
        Gray,
        Color.Black,
        Color.Black
    )
}

@Composable
fun AudioJournalTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}