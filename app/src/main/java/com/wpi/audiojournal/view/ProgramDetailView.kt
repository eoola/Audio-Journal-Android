package com.wpi.audiojournal.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.models.Program
import com.wpi.audiojournal.screen.MenuView
import com.wpi.audiojournal.viewmodels.GeneralEpisodeViewModel

@Composable
fun ProgramDetailView(navController: NavController, title: String,name: String, airTime: String, description: String, episodeViewModel: GeneralEpisodeViewModel){
    episodeViewModel.loadEpisodes(name)
    val episodes by episodeViewModel.uiState.collectAsState()


    var menuItems: List<MenuItem> = listOf()
    var progList: List<Program> = listOf()
    //val progHash = HashMap<String, String>()
    //programsViewModel.onResultConsumed()

    if(episodes.menuItems != null){

        menuItems= episodes.menuItems

    }

    MenuView(
        screenType = "program detail",
        title = title,
        navController = navController,
        hasBackButton = true,
        hasFavorites = true,
        airTime = airTime,
        description = description,
        menuItems = menuItems,
        hasColorPalette = false,
        hasSearch = false,
        headerSpace = 225
    )
}