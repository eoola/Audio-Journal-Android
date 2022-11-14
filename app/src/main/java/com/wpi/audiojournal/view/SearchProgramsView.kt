package com.wpi.audiojournal.view

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.models.Program
import com.wpi.audiojournal.models.data.allPrograms
import com.wpi.audiojournal.ui.component.Loading
import com.wpi.audiojournal.ui.component.Menu
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.ui.component.Search
import com.wpi.audiojournal.viewmodels.CategoryViewModel
import com.wpi.audiojournal.viewmodels.ScheduleViewModel
import com.wpi.audiojournal.viewmodels.SearchProgramsViewModel

@Composable
fun SearchProgramsView(navController: NavController, title: String){//, menuItems: MutableList<Program>){

    var menuItems = allPrograms






    PageSkeleton(header = title) {
        //Loading(data = programV1.programs) {
            /*for (p1 in it) {
                menuItems.add(p1)
            }*/
            val viewModelProg = SearchProgramsViewModel(menuItems)

            Search(navController, viewModelProg )
        //}


    }
}

/*
@Composable
fun ProgramLoad1(navController: NavController, title: String){
    val programV: CategoryViewModel = viewModel()
    LaunchedEffect(LocalContext.current){
        programV.loadPrograms("local-newspaper")
        //programV1.loadPrograms("retail-circular-sale")
        //programV2.loadPrograms("specialty-program")
    }
    var menuItems = mutableListOf<Program>()
    //PageSkeleton(header = title) {
        Loading(data = programV.programs) {
            for (p in it) {
                menuItems.add(p)
            }
            ProgramLoad2(navController, title, menuItems)

        }
    //}

}

@Composable
fun ProgramLoad2(navController: NavController, title: String, programs: MutableList<Program>){
    val programV1: CategoryViewModel = viewModel()
    LaunchedEffect(LocalContext.current){
        programV1.loadPrograms("retail-circular-sale")
        //programV1.loadPrograms("retail-circular-sale")
        //programV2.loadPrograms("specialty-program")
    }

    //PageSkeleton(header = title) {
        Loading(data = programV1.programs) {
            for (p in it) {
                programs.add(p)
            }
            ProgramLoad3(navController, title, programs)


        }
    //}

}

@Composable
fun ProgramLoad3(navController: NavController, title: String, programs: MutableList<Program>){
    val programV2: CategoryViewModel = viewModel()
    LaunchedEffect(LocalContext.current){
        programV2.loadPrograms("specialty-program")
        //programV1.loadPrograms("retail-circular-sale")
        //programV2.loadPrograms("specialty-program")
    }

   // PageSkeleton(header = title) {
        Loading(data = programV2.programs) {
            for (p in it) {
                programs.add(p)
            }
            SearchProgramsView(navController = navController, title = title, menuItems = programs)

        }
    //}*/

//}