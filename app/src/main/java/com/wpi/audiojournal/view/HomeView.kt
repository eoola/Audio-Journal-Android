package com.wpi.audiojournal.view

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.ui.component.Menu
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.ui.theme.Blue
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
        Button(onClick = { setColorScheme(nextColorScheme(colors)) }) {
            Text(text = "Color")
        }
    }
}