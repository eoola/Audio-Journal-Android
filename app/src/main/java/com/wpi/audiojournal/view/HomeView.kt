package com.wpi.audiojournal.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.ui.component.Menu
import com.wpi.audiojournal.ui.component.PageSkeleton

@Composable
fun HomeView(menuItems: List<MenuItem>, navController: NavController) {
    PageSkeleton(header = "Audio Journal") {
        Menu(menuItems = menuItems, navController = navController)
    }
}