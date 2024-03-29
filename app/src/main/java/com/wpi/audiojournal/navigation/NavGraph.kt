package com.wpi.audiojournal.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wpi.audiojournal.StoreData
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.view.SplashScreenView
import com.wpi.audiojournal.ui.theme.ColorScheme
import com.wpi.audiojournal.view.*
import com.wpi.audiojournal.viewmodels.FavoritesViewModel

@Composable
fun SetupNavGraph(navController: NavHostController, initialRoute: suspend () -> String, setColorScheme: (ColorScheme) -> Unit) {
    NavHost(navController = navController, startDestination = "loading") {

        composable("loading") {
            SplashScreenView(navController = navController, initialRoute)
        }

        composable("home") {
            HomeView(
                menuItems = listOf(
                    MenuItem("Listen Live", "listen-live"),
                    MenuItem("Archived Programs", "archived-programs"),
                    MenuItem("Resume Last Broadcast", "resume-last-broadcast"),
                    MenuItem("Favorite Programs", "favorite-programs"),
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
            val viewModel = FavoritesViewModel(StoreData(LocalContext.current))
            ProgramDetailView(
                navController = navController,
                title = title,
                name = name,
                viewModel
            )
        }

        composable("listen-live"){
            ListenLiveView( "Listen Live")
        }

        composable("media-player/{menuTitle}/{uriLink}"){navBackStackEntry ->
            val title = navBackStackEntry.arguments?.getDecodedString("menuTitle") ?: ""
            val uriLink = navBackStackEntry.arguments?.getDecodedString("uriLink") ?: ""
            MediaPlayerView(title = title, uriString = uriLink, playTime = 0L)
        }

        composable("resume-last-broadcast"){
            val viewModel = FavoritesViewModel(StoreData(LocalContext.current))
            val title = viewModel.getTitle()
            val playTime = viewModel.getPlayTime()
            val link = viewModel.getProgramLink()

            if (title != null && link != null && playTime != null) {
                    MediaPlayerView(title = title, uriString = link, playTime = playTime)
            }
            else{
                Toast.makeText(LocalContext.current, "No previous program played", Toast.LENGTH_LONG).show()
                MediaPlayerView(title = "Audio Journal", uriString = "", playTime = 0)
            }
        }

        composable("favorite-programs"){
            val viewModel = FavoritesViewModel(StoreData(LocalContext.current))
            FavoritesView(menuItems = viewModel.createFavoritesButtons(), navController = navController)
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

        composable("search_button?q={q}"){
            SearchProgramsView(navController = navController, title = "Search Programs",
                it.arguments?.getString("q")
            )
        }
    }
}
