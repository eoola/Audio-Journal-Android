package com.wpi.audiojournal.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.wpi.audiojournal.models.MenuItem

@Composable
fun ArchiveCategoriesView(menuItems: List<MenuItem>, navController: NavController) {

    MenuView(
        screenType = "Archived",
        title = "Program Categories",
        navController = navController,
        hasBackButton = true,
        hasFavorites = false,
        menuItems = menuItems,
        hasColorPalette = false,
        hasSearch = true,
        headerSpace = 100
    )
}