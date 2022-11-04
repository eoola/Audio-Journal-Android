package com.wpi.audiojournal.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

import com.wpi.audiojournal.ui.component.Loading
import com.wpi.audiojournal.ui.component.Menu
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.viewmodels.ProgramViewModel

@Composable
fun ProgramDetailView(navController: NavController, title: String, name: String, viewModel: ProgramViewModel = viewModel()){
    LaunchedEffect(name) {
        viewModel.loadEpisodes(name)
    }

    PageSkeleton(header = title) {
        Loading(data = viewModel.program) { program ->
            Text(text = program.description)
            program.episodes?.let {
                Menu(menuItems = it, navController = navController)
            }
        }
    }


}
