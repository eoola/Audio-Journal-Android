package com.wpi.audiojournal.view

import android.provider.Settings.Global.getString
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.google.gson.reflect.TypeToken.getArray
import com.wpi.audiojournal.R
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.screen.MenuView

@Composable
fun HelpMenuView(navController: NavController) {

    val menuItems = mutableListOf<MenuItem>()
   // var name: String = getString(R.string.ajo_infoD)
   // var itemArr: Array<String> = getArray(R.array.help_items.)


    menuItems.add(MenuItem("Audio Journal Info"))
    menuItems.add(MenuItem("Media Player"))
    menuItems.add(MenuItem("Finding Programs with the Browsing Menu"))
    menuItems.add(MenuItem("Finding Programs with the Search Bar"))
    menuItems.add(MenuItem("Finding Programs with Search By Voice"))
    menuItems.add(MenuItem("Favoriting Programs"))
    menuItems.add(MenuItem("Color Palette Changer"))

    MenuView(
        screenType = "Help",
        title = "Help",
        navController = navController,
        hasBackButton = false ,
        hasFavorites = false,
        menuItems = menuItems,
        hasColorPalette = false,
        hasSearch = false,
        headerSpace = 100
    )
}