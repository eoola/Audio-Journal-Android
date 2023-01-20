package com.wpi.audiojournal.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.wpi.audiojournal.ui.component.GetAirtimeMap
import com.wpi.audiojournal.ui.component.Loading
import com.wpi.audiojournal.ui.component.Menu
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.ui.theme.LocalColorScheme
import com.wpi.audiojournal.viewmodels.ArchiveViewModel

@Composable
fun ArchiveView(navController: NavController, viewModel: ArchiveViewModel = viewModel()){

    LaunchedEffect(LocalContext.current) {
        viewModel.loadCategories()
    }

    PageSkeleton(header = "Program Categories") {

            Button(
                modifier = Modifier
                    .padding(
                        horizontal = 24.dp,
                        vertical = 5.dp
                    ).fillMaxWidth()
                    .size(width = 100.dp, height = 40.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = CircleShape,
                border = BorderStroke(2.dp, LocalColorScheme.current.borders),
                onClick = {
                    navController.navigate("search_button")

                }
            ){
                Text(
                    text = "Search Programs",
                    color = Color.Black,
                    style = MaterialTheme.typography.subtitle1
                )

            }

        Loading(data = viewModel.categories) {
            Menu(menuItems = it, navController = navController)
        }
    }
}