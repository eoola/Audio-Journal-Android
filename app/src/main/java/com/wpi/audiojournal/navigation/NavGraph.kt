package com.wpi.audiojournal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.screen.SplashScreen
import com.wpi.audiojournal.view.*

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "loading") {


        composable("loading") {
            SplashScreen(navController = navController)
        }
        composable("home") {
            HomeView(
                menuItems = listOf(
                    MenuItem("Listen Live", "listen-live"),
                    MenuItem("Archived Programs", "archived-programs"),
                    MenuItem("Resume Last Broadcast", ""),
                    MenuItem("Favorite Programs", ""),
                    MenuItem("Program Schedule", "program-schedule"),
                    MenuItem("Help", "help")
                ), navController = navController
            )
        }

        composable("program-schedule"){
            ProgramScheduleView(menuItems = listOf(
                MenuItem("Sunday", "program-schedule/Sunday"),
                MenuItem("Monday", "program-schedule/Monday"),
                MenuItem("Tuesday", "program-schedule/Tuesday"),
                MenuItem("Wednesday", "program-schedule/Wednesday"),
                MenuItem("Thursday", "program-schedule/Thursday"),
                MenuItem("Friday", "program-schedule/Friday"),
                MenuItem("Saturday", "program-schedule/Saturday")
            ), navController = navController)
        }

        composable("program-schedule/{day}"){ navbackStackEntry ->
            DailyScheduleView(navbackStackEntry.arguments?.getString("day") ?: "")
        }

        composable("archived-programs") {
            ArchiveCategoriesView(navController = navController)
        }


        composable("program-option/{menuTitle}/{name}") { navBackStackEntry ->
            val title = navBackStackEntry.arguments?.getDecodedString("menuTitle") ?: ""
            val name = navBackStackEntry.arguments?.getDecodedString("name") ?: ""

            ProgramOptionsView(
                navController = navController,
                title = title,
                name = name
            )
        }

        composable("program-detail/{menuTitle}/{name}") { navBackStackEntry ->
            val title = navBackStackEntry.arguments?.getDecodedString("menuTitle") ?: ""
            val name = navBackStackEntry.arguments?.getDecodedString("name") ?: ""
            ProgramDetailView(
                navController = navController,
                title = title,
                name = name
            )
        }

        composable("listen-live"){
            ListenLiveView( "Listen Live")
        }

        composable("media-player/{menuTitle}/{uriLink}"){navBackStackEntry ->
            val title = navBackStackEntry.arguments?.getDecodedString("menuTitle") ?: ""
            val uriLink = navBackStackEntry.arguments?.getDecodedString("uriLink") ?: ""
            MediaPlayerView(title = title, uriString = uriLink)
        }
    }
}
