package com.wpi.audiojournal.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.wpi.audiojournal.ui.component.Menu
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.viewmodels.GeneralEpisodeViewModel

@Composable
fun ProgramDetailView(navController: NavController, title: String,name: String, episodeViewModel: GeneralEpisodeViewModel = viewModel()){
    episodeViewModel.loadEpisodes(name)
    val episodes by episodeViewModel.uiState.collectAsState()

    PageSkeleton(header = title) {
        Menu(menuItems = episodes.episodeList, navController = navController)
    }
}