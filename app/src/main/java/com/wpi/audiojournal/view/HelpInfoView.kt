package com.wpi.audiojournal.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.wpi.audiojournal.uikit.ButtonComponents
import com.wpi.audiojournal.uikit.Header
import com.wpi.audiojournal.uikit.HelpInfo

@Composable
fun HelpInfoView(title:String, navController: NavController){
    var colorsObject = AppColorSchemes()
    val color = colorResource(id =colorsObject.getBackground())
    Column(modifier = Modifier
        .background(color = color)
        .fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Header(
            menuType = "helpInfo",
            title = title,
            navController = navController,
            hasBackButton = false,
            hasFavorites = false,
            colorsObj = colorsObject
        )

        HelpInfo(helpCategory = title, colorsObj = colorsObject)

    }
}