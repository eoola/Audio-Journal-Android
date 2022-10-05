package com.wpi.audiojournal.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.uikit.Header
import com.wpi.audiojournal.view.AppColorSchemes
import com.wpi.audiojournal.view.ColorScheme

@Composable
fun HomeView(menuItems: List<MenuItem>, navController: NavController) {


    MenuView(
        screenType = "Home",
        title = "Audio Journal",
        navController = navController,
        hasBackButton = false,
        hasFavorites = false,
        menuItems = menuItems,
        hasColorPalette = true,
        hasSearch = false,
        headerSpace = 70
    )
}