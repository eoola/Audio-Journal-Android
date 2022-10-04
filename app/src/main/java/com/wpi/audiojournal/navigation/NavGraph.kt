package com.wpi.audiojournal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.screen.HomeScreen
import com.wpi.audiojournal.screen.ProgramCategoriesScreen
import com.wpi.audiojournal.screen.SplashScreen
import com.wpi.audiojournal.data.DataStuff
import com.wpi.audiojournal.screen.*

@Composable
fun SetupNavGraph(navController: NavHostController, data: ArchiveDataObjects){
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
        composable("moreGeneralCategory/{menuTitle}"){
                navBackStackEntry ->  val menuItemTitle = navBackStackEntry.arguments?.getString("menuTitle")
            GeneralCategoryScreen(menuItems = data.getMenuItems(menuItemTitle.toString(), "general program categories"), navController = navController)
        }
        composable("category/{menuTitle}"){
           navBackStackEntry ->  val menuItemTitle = navBackStackEntry.arguments?.getString("menuTitle")
            GeneralProgramsScreen(
                menuItems = data.getMenuItems(menuItemTitle.toString(),"general programs"),
                navController = navController,
                title = menuItemTitle.toString(),
                airtime = data.getProgramInformation(menuItemTitle.toString())[0],
                description = data.getProgramInformation(menuItemTitle.toString())[1]
            )
        }
    }
}
