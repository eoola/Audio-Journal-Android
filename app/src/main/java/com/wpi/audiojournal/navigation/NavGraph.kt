package com.wpi.audiojournal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.screen.SplashScreen
import com.wpi.audiojournal.ui.theme.ColorScheme
import com.wpi.audiojournal.view.*

@Composable
fun SetupNavGraph(navController: NavHostController, setColorScheme: (ColorScheme) -> Unit) {
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
                ),
                navController = navController,
                setColorScheme = setColorScheme
            )
        }

        composable("program-schedule"){
            ProgramScheduleView(menuItems =
                listOf(
                    "Sunday",
                    "Monday",
                    "Tuesday",
                    "Wednesday",
                    "Thursday",
                    "Friday",
                    "Saturday"
                ).map{ day -> MenuItem(day, "program-schedule/$day") },
                navController = navController)
        }

        composable("program-schedule/{day}"){ navbackStackEntry ->
            DailyScheduleView(navbackStackEntry.arguments?.getString("day") ?: "Sunday")
        }

        composable("archived-programs") {
            ArchiveView(navController = navController)
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


        composable("help") {
            HelpMenuView(
                menuItems = listOf(
                    MenuItem("Audio Journal Info", "help-info/audio-journal-info"),
                    MenuItem("Media Player", "help-info/media-player"),
                    MenuItem("Finding Programs with the Browsing Menu", "help-info/browsing-menu"),
                    MenuItem("Finding Programs with the Search Bar", "help-info/search-bar"),
                    MenuItem("Finding Programs with Search By Voice", "help-info/search-by-voice"),
                    MenuItem("Favoriting Programs", "help-info/favoriting"),
                    MenuItem("Color Palette Changer", "help-info/color-changer")
                ), navController = navController
            )
        }
        
        composable("help-info/{screenId}"){navBackStackEntry ->
            val screenID = navBackStackEntry.arguments?.getDecodedString("screenId") ?: ""
            HelpInfoView(uriString = screenID)
            
        }
        composable("search_button"){
            SearchProgramsView(navController = navController, title = "Search Programs")
            //ProgramLoad1(navController = navController, title = "Search Programs")
        }
    }
}
