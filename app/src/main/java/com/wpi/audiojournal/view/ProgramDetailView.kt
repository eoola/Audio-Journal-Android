package com.wpi.audiojournal.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.screen.MenuView

@Composable
fun ProgramDetailView(menuItems: List<MenuItem>, navController: NavController, title: String, airTime: String, description: String){
    MenuView(
        screenType = "program detail",
        title = title,
        navController = navController,
        hasBackButton = true,
        hasFavorites = true,
        airTime = airTime,
        description = description,
        menuItems = menuItems,
        hasColorPalette = false,
        hasSearch = false,
        headerSpace = 225
    )
}