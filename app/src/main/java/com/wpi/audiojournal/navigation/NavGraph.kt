package com.wpi.audiojournal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.screen.HomeScreen
import com.wpi.audiojournal.screen.ProgramCategoriesScreen
import com.wpi.audiojournal.screen.SplashScreen

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "loading"){

        composable("loading"){
            SplashScreen(navController = navController)
        }
        composable("home"){
            HomeScreen(menuItems = listOf(
                MenuItem("Listen Live"),
                MenuItem("Archived Programs"),
                MenuItem("Resume Last Broadcast"),
                MenuItem("Favorite Programs"),
                MenuItem("Program Schedule"),
                MenuItem("Help")
            ), navController=navController)
        }
        composable("Archived Programs"){
            ProgramCategoriesScreen(menuItems = listOf(
                MenuItem("Local Newspaper"),
                MenuItem("Retail Circulars and Sales"),
                MenuItem("Specialty Program")), navController=navController)
        }
    }
}
