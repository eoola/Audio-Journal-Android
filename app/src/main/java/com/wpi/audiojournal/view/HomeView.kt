package com.wpi.audiojournal.view

import androidx.compose.foundation.Image
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.wpi.audiojournal.R
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.ui.component.Menu
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.ui.theme.ColorScheme
import com.wpi.audiojournal.ui.theme.LocalColorScheme
import com.wpi.audiojournal.ui.theme.nextColorScheme

@Composable
fun HomeView(
    menuItems: List<MenuItem>,
    navController: NavController,
    setColorScheme: (ColorScheme) -> Unit
) {
    val colors = LocalColorScheme.current
    PageSkeleton(header = "Audio Journal") {
        Menu(menuItems = menuItems, navController = navController)
        IconButton(onClick = { setColorScheme(nextColorScheme(colors)) }) {
            Image(
                painter = painterResource(R.drawable.color_palette_icon),
                contentDescription = "Color Palette Icon"
            )
        }
    }
}