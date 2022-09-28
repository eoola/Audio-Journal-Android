package com.wpi.audiojournal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.wpi.audiojournal.MenuItem
import com.wpi.audiojournal.screen.DailySchedule
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.screen.HomeScreen
import com.wpi.audiojournal.screen.ProgramSchedule
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
            ), navController = navController)
        }
        composable("Program Schedule"){
            ProgramSchedule(menuItems = listOf(
                MenuItem("Sunday"),
                MenuItem("Monday"),
                MenuItem("Tuesday"),
                MenuItem("Wednesday"),
                MenuItem("Thursday"),
                MenuItem("Friday"),
                MenuItem("Saturday")
            ), navController = navController, title = "Program Schedule")
        }

        composable("${Screens.programScheduleScreen.route}/{day}", arguments = listOf(navArgument("day") { type = NavType.StringType })){
            DailySchedule(navController = navController, title = it.arguments?.getString("day"))
        }
    }
}
