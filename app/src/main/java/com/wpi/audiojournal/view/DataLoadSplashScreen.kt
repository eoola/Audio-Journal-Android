package com.wpi.audiojournal.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun DataLoadSplashScreen() {
    var colorsObject = AppColorSchemes()
    val color = colorResource(id =colorsObject.getBackground())
    Column(modifier = Modifier.background(color = color).fillMaxSize().padding(100.dp),

        horizontalAlignment = Alignment.CenterHorizontally
        //verticalArrangement = Alignment.CenterVertically
    ) {
        CircularProgressIndicator()
    }
}