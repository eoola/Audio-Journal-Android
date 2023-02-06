package com.wpi.audiojournal.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.wpi.audiojournal.navigation.Navigable
import com.wpi.audiojournal.navigation.Titled
import com.wpi.audiojournal.ui.theme.LocalColorScheme
import com.wpi.audiojournal.viewmodels.VoiceInputViewModel


@Composable
fun <T> Menu (menuItems: List<T>, navController: NavController, viewModel: VoiceInputViewModel = viewModel()) where T : Navigable, T : Titled {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp
    val menH = screenHeight-130
    val menW = screenWidth
    val butH = menH/7
    val butW = menW-10
    var buttonTextSize = butH/5

    LazyColumn {
        rainbow(menuItems) { menuItem, color ->
            Button(
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
                    .fillMaxSize()
                    .size(width = butW.dp, height = (butH).dp),
                colors = ButtonDefaults.buttonColors(color),
                shape = CircleShape,
                border = BorderStroke(2.dp, LocalColorScheme.current.borders),
                onClick = {
                    navController.navigate(menuItem.uri)
                }
            ) {

                Text(
                    text = menuItem.title,
                    color = LocalColorScheme.current.content,
                    style = MaterialTheme.typography.subtitle1,
                    textAlign = TextAlign.Center,
                    fontSize = buttonTextSize.sp
                )
            }
        }
    }
}