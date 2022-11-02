package com.wpi.audiojournal.view

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.models.Program
import com.wpi.audiojournal.screen.MenuView
import com.wpi.audiojournal.viewmodels.GeneralEpisodeViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ProgramDetailView(navController: NavController, title: String,name: String, airTime: String, description: String, episodeViewModel: GeneralEpisodeViewModel){

   // val episodeViewModel2= GeneralEpisodeViewModel()

    episodeViewModel.loadEpisodes(name)
    val episodes by episodeViewModel.uiState.collectAsState()

    if(episodes.menuItems.isNullOrEmpty()){//|| !title.contains(episodes.menuItems[0].title.split(" ").toString())){
        DataLoadSplashScreen()

    }else{

    var menuItems: List<MenuItem> = listOf()
    //var progList: List<Program> = listOf()
    //val progHash = HashMap<String, String>()
    //programsViewModel.onResultConsumed()

    if(episodes.menuItems != null){

        menuItems= episodes.menuItems
        Log.d("TEST", menuItems[0].title.toString())

    }

    //if(menuItems.isEmpty()){
      //  DataLoadSplashScreen()

    //}else {

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
}