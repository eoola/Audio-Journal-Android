package com.wpi.audiojournal.view

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.wpi.audiojournal.models.Category
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.models.MenuType
import com.wpi.audiojournal.models.Program
import com.wpi.audiojournal.screen.MenuView
import com.wpi.audiojournal.viewmodels.GeneralProgramsViewModel

@Composable
fun ProgramOptionsView(navController: NavController, title: String, name: String, programsViewModel: GeneralProgramsViewModel, progLoaded: Boolean){

    //if(!progLoaded){

        //val programsOld by programsViewModel.uiState.collectAsState()

        programsViewModel.loadPrograms(name)
        val programs by programsViewModel.uiState.collectAsState()



    if(programs.menuItems.isNullOrEmpty()){
       // Log.d("TEST", "title: ${title}")
        //Log.d("TEST", "menuName: ${programs.menuItems}")
        DataLoadSplashScreen()

    }


    else{
        var menuItems: List<MenuItem> = listOf()
        //var progList: List<Program> = listOf()
        //val progHash = HashMap<String, String>()
    //programsViewModel.onResultConsumed()

        if(programs.menuItems != null){

            menuItems= programs.menuItems

        }

        //progLoaded = true
    //}


    /*if(programs.programList != null){
        progList = programs.programList
        for(p in progList){
            progHash.put(p.title, p.name)
        }
    }*/

    //if(menuItems.isEmpty()){
    //    DataLoadSplashScreen()

    //}else {

        MenuView(
            screenType = "program option",
            title = title,
            navController = navController,
            hasBackButton = true,
            hasFavorites = false,
            menuItems = menuItems,
            hasColorPalette = false,
            hasSearch = false,
            headerSpace = 100
            //navData = progHash
        )
    }

}