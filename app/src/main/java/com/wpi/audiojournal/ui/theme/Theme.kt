package com.wpi.audiojournal.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

private fun DarkColorPalette(colorScheme: ColorScheme) = darkColors(
    primary = colorScheme.getRainbowColor(0),
    primaryVariant = colorScheme.getRainbowColor(1),
    secondary = colorScheme.getRainbowColor(2)
)

private fun LightColorPalette(colorScheme: ColorScheme) = lightColors(
    primary = colorScheme.getRainbowColor(0),
    primaryVariant = colorScheme.getRainbowColor(1),
    secondary = colorScheme.getRainbowColor(2)
)

data class ColorScheme(val colors: List<Color>, val background: Color, val content: Color, val borders: Color) {
    fun getRainbowColor(index: Int) = colors[index % colors.size]
}

val colorSchemes = listOf(
    ColorScheme(
        listOf(Purple, Salmon, Orange, Teal, Yellow, Blue),
        Gray,
        Color.Black,
        Color.Black
    ),
    ColorScheme(
        listOf(Color.White),
        Blue,
        Color.Black,
        Color.Black
    ),
    ColorScheme(
        listOf(Color.White),
        Teal,
        Color.Black,
        Color.Black
    )
)

fun nextColorScheme (from: ColorScheme) =
    colorSchemes[colorSchemes.indexOf(from).inc().mod(colorSchemes.size)]


val LocalColorScheme = staticCompositionLocalOf { colorSchemes.first() }

@Composable
fun AudioJournalTheme(darkTheme: Boolean = isSystemInDarkTheme(),
                      content: @Composable ((ColorScheme) -> Unit) -> Unit) {
    val (colorScheme, setColorScheme) = remember {
        mutableStateOf(colorSchemes.first())
    }

    val colors = if (darkTheme) {
        DarkColorPalette(colorScheme)
    } else {
        LightColorPalette(colorScheme)
    }

    CompositionLocalProvider (LocalColorScheme provides colorScheme) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = { content(setColorScheme) }
        )
    }
}