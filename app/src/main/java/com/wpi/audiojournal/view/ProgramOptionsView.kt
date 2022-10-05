package com.wpi.audiojournal.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.wpi.audiojournal.models.MenuItem

@Composable
fun ProgramOptionsView(menuItems: List<MenuItem>, navController: NavController, title: String){
    MenuView(
        screenType = "program option",
        title = title,
        navController = navController,
        hasBackButton = true,
        hasFavorites = false,
        menuItems = menuItems,
        hasColorPalette = false,
        hasSearch = false,
        headerSpace = 100
    )

}