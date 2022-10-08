package com.wpi.audiojournal.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.wpi.audiojournal.models.MenuItem


@Composable
fun ProgramSchedule(menuItems: List<MenuItem>, navController: NavController) {


    MenuView(
        screenType = "Program Schedule",
        title = "Program Schedule",
        navController = navController,
        hasBackButton = true,
        hasFavorites = false,
        menuItems = menuItems,
        hasColorPalette = true,
        hasSearch = false,
        headerSpace = 70
    )
    }
