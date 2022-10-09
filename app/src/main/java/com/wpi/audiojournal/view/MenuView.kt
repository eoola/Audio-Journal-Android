package com.wpi.audiojournal.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.models.MenuType
import com.wpi.audiojournal.uikit.ButtonComponents
import com.wpi.audiojournal.uikit.Header
import com.wpi.audiojournal.view.AppColorSchemes

@Composable
fun MenuView(
    screenType: String,
    title: String,
    navController: NavController,
    hasBackButton: Boolean,
    hasFavorites: Boolean,
    airTime: String?=null,
    description: String?=null,
    menuItems: List<MenuItem>,
    hasColorPalette: Boolean,
    hasSearch: Boolean,
    headerSpace: Int,
    navData: HashMap<String,String>? = null

    ){

    //Log.d("TEST", "IN MENUVIEW")

    var colorsObject = AppColorSchemes()
    val color = colorResource(id =colorsObject.getBackground())
    Column(modifier = Modifier.background(color = color).fillMaxSize()) {
        Header(
            menuType = screenType,
            title = title,
            navController = navController,
            hasBackButton = hasBackButton,
            hasFavorites = hasFavorites,
            airTime = airTime,
            description = description,
            colorsObject
        )

        ButtonComponents(menuType = screenType, menuItems = menuItems, navController = navController, hasColorPallette = hasColorPalette, hasSearch = hasSearch, headerSpace = headerSpace, colorsObject,navData)
    }

}