package com.wpi.audiojournal.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.wpi.audiojournal.ui.component.Loading
import com.wpi.audiojournal.ui.component.Menu
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.viewmodels.CategoryViewModel

@Composable
fun ProgramOptionsView(navController: NavController, title: String, name: String, viewModel: CategoryViewModel = viewModel()){
    LaunchedEffect(name) {
        viewModel.loadPrograms(name)
    }

    PageSkeleton(header = title) {
        Loading(data = viewModel.programs) {
            Menu(menuItems = it, navController = navController)
        }
    }
}
