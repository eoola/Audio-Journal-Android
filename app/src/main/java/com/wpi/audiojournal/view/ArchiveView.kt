package com.wpi.audiojournal.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.wpi.audiojournal.ui.component.Loading
import com.wpi.audiojournal.ui.component.Menu
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.viewmodels.ArchiveViewModel

@Composable
fun ArchiveView(navController: NavController, viewModel: ArchiveViewModel = viewModel()){
    LaunchedEffect(LocalContext.current) {
        viewModel.loadCategories()
    }

    PageSkeleton(header = "Program Categories") {
        Loading(data = viewModel.categories) {
            Menu(menuItems = it, navController = navController)
        }
    }
}