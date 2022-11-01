package com.wpi.audiojournal.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.wpi.audiojournal.ui.component.Menu
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.viewmodels.GeneralProgramsViewModel

@Composable
fun ProgramOptionsView(navController: NavController, title: String, name: String, programsViewModel: GeneralProgramsViewModel = viewModel()){

    programsViewModel.loadPrograms(name)
    val programs by programsViewModel.uiState.collectAsState()

    PageSkeleton(header = title) {
        Menu(menuItems = programs.programList, navController = navController)
    }
}