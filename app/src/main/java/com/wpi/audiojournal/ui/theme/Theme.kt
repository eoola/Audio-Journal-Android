package com.wpi.audiojournal.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.wpi.audiojournal.StoreData
import com.wpi.audiojournal.viewmodels.FavoritesViewModel

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

data class ColorScheme(val colors: List<Color>, val background: Color, val content: Color, val borders: Color, val pageContent: Color) {
    fun getRainbowColor(index: Int) = colors[index % colors.size]
}

val colorSchemes = listOf(
    ColorScheme(
        listOf(Purple, Salmon, Orange, Teal, Yellow, Blue),
        Gray,
        Color.Black,
        Color.Black,
        Color.Black
    ),
    ColorScheme(
        listOf(Color.White),
        Blue,
        Color.Black,
        Color.Black,
        Color.Black
    ),
    ColorScheme(
        listOf(Color.White),
        Teal,
        Color.Black,
        Color.Black,
        Color.Black
    ),
    ColorScheme(
        listOf(Color.White),
        Yellow,
        Color.Black,
        Color.Black,
        Color.Black
    ),
    ColorScheme(
        listOf(Color.White),
        Brown,
        Color.Black,
        Color.Black,
        Color.White
    ),
    ColorScheme(
        listOf(Color.Black),
        Color.White,
        Color.White,
        Color.Black,
        Color.Black
    )
)
fun nextColorScheme (from: ColorScheme, viewModel: FavoritesViewModel): ColorScheme {
    viewModel.addColorScheme(colorSchemes.indexOf(from).inc().mod(colorSchemes.size))
    return colorSchemes[colorSchemes.indexOf(from).inc().mod(colorSchemes.size)]
}

var LocalColorScheme = compositionLocalOf { colorSchemes.first() }

@Composable
fun AudioJournalTheme(darkTheme: Boolean = isSystemInDarkTheme(),
                      content: @Composable ((ColorScheme) -> Unit) -> Unit) {
    val viewModel = FavoritesViewModel(StoreData(LocalContext.current))
    val (colorScheme, setColorScheme) = remember {
        mutableStateOf(colorSchemes[viewModel.getColorScheme()!!])
    }

    val colors = if (darkTheme) {
        DarkColorPalette(colorScheme)
    } else {
        LightColorPalette(colorScheme)
    }


//    LocalColorScheme = compositionLocalOf { colorSchemes[viewModel.getColorScheme()!!]}


    CompositionLocalProvider (LocalColorScheme provides colorScheme) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = { content(setColorScheme) }
        )
    }
}