package com.wpi.audiojournal.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.ui.component.Menu
import com.wpi.audiojournal.ui.component.PageSkeleton

@Composable
fun HelpMenuView(menuItems: List<MenuItem>, navController: NavController){
    PageSkeleton(header = "Help") {
        Menu(menuItems = menuItems, navController = navController)
    }
}