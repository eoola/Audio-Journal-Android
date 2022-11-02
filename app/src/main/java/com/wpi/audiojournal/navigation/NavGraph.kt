package com.wpi.audiojournal.navigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.screen.DailySchedule
import com.wpi.audiojournal.screen.HomeScreen
import com.wpi.audiojournal.screen.ListenLiveView
import com.wpi.audiojournal.screen.ProgramCategoriesScreen
import com.wpi.audiojournal.screen.ProgramSchedule
import com.wpi.audiojournal.screen.SplashScreen
//import com.wpi.audiojournal.data.DataStuff
import com.wpi.audiojournal.models.CategoriesDTO
import com.wpi.audiojournal.models.MenuItemFactory
import com.wpi.audiojournal.screen.*
import com.wpi.audiojournal.viewmodels.ScheduleViewModel

import com.wpi.audiojournal.view.ProgramDetailView
import com.wpi.audiojournal.view.*
import com.wpi.audiojournal.viewmodels.GeneralCategoryViewModel
import com.wpi.audiojournal.viewmodels.GeneralEpisodeViewModel
import com.wpi.audiojournal.viewmodels.GeneralProgramsViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun SetupNavGraph(navController: NavHostController, viewModC: GeneralCategoryViewModel, viewModP: GeneralProgramsViewModel, episodeViewModel: GeneralEpisodeViewModel, progLoaded:Boolean) {//, items: MenuItemFactory) {
    NavHost(navController = navController, startDestination = "loading") {


        composable("loading") {
            SplashScreen(navController = navController)
        }
        composable("Home") {
            HomeView(
                menuItems = listOf(
                    MenuItem("Listen Live"),
                    MenuItem("Archived Programs"),
                    MenuItem("Resume Last Broadcast"),
                    MenuItem("Favorite Programs"),
                    MenuItem("Program Schedule"),
                    MenuItem("Help")
                ), navController = navController
            )
        }

        composable("Help") {
            HelpMenuView(
                navController = navController
            )
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
            ), navController = navController)
        }

        composable("${Screens.programScheduleScreen.route}/{day}", arguments = listOf(navArgument("day") { type = NavType.StringType })){
                navbackStackEntry ->
            val viewModel = ScheduleViewModel()
            DailySchedule(navController = navController, title = navbackStackEntry.arguments?.getString("day"), viewModel)
        }

        composable("Archived Programs") {
            //var menuItems = items.getCategories()//items.getMenuItems("Archived Programs")
            //if (menuItems != null) {
            ArchiveCategoriesView(navController = navController, viewModC)
            // } else {

            //}

            /*
            ProgramCategoriesScreen(menuItems = listOf(
                MenuItem("Local Newspaper"),
                MenuItem("Retail Circulars and Sales"),
                MenuItem("Specialty Program")), navController=navController)*/
        }


        composable("program-option/{menuTitle}/{name}") { navBackStackEntry ->
            val menuItemTitle = navBackStackEntry.arguments?.getString("menuTitle")
            val title = menuItemTitle.toString().replace("_"," ")
            val name = navBackStackEntry.arguments?.getString("name").toString()
            viewModP.uiState.value.menuItems= emptyList()
            ProgramOptionsView(
                navController = navController,
                title = title,
                name = name,
                programsViewModel = viewModP,
                progLoaded = progLoaded

            )
        }

        composable("program-detail/{menuTitle}/{name}/{description}") { navBackStackEntry ->
            val menuItemTitle = navBackStackEntry.arguments?.getString("menuTitle")
            val title = menuItemTitle.toString().replace("_"," ")
            val name = navBackStackEntry.arguments?.getString("name").toString()
            val desc = navBackStackEntry.arguments?.getString("description").toString()
            Log.d("TEST","Name prog? ${name}")
            episodeViewModel.uiState.value.menuItems = emptyList()
            ProgramDetailView(
                navController = navController,
                title = title,
                name = name,
                episodeViewModel = episodeViewModel,
                airTime = "",
                description = desc

            )
        }

        composable("Listen Live"){
            ListenLiveView( "Listen Live", navController=navController)
        }

        composable("media-player/{menuTitle}/{uriLink}"){navBackStackEntry ->
            val menuItemTitle = navBackStackEntry.arguments?.getString("menuTitle")
            val title = menuItemTitle.toString().replace("_"," ").replace("~", "/")
            val uriLink = navBackStackEntry.arguments?.getString("uriLink").toString().replace("~", "/").replace("http:", "https:")
            MediaPlayerView(title = title, navController = navController, uriString = uriLink)
        }

        composable("help-info/{menuTitle}/{name}"){
            navBackStackEntry ->   val menuItemTitle = navBackStackEntry.arguments?.getString("menuTitle")
            val title = menuItemTitle.toString().replace("_"," ").replace("~", "/")
            HelpInfoView(title = title, navController = navController)
        }

        /*var menuItems = items.getProgramsByCategory(title)
            //var menuItems = items.getMenuItems(title)
            if (menuItems != null) {
                ProgramOptionsView(
                    menuItems = menuItems,
                    navController = navController,
                    title = title
                )
            } else {

            }*/

    }
}

        /*composable("program detail/{menuTitle}") { navBackStackEntry ->
            val menuItemTitle = navBackStackEntry.arguments?.getString("menuTitle")
            val title = menuItemTitle.toString()
            var menuItems = items.getMenuItems(title)
            var category = data.categories[title]
            var desc = ""

            if (category != null) {
                desc = category.description
            }
            ProgramDetailView(
                menuItems = menuItems,
                navController = navController,
                title = title,
                airTime = "",
                description = desc//FIGURE OUT
            )

        }
    //}

//}


        composable("moreGeneralCategory/{menuTitle}"){
                navBackStackEntry ->  val menuItemTitle = navBackStackEntry.arguments?.getString("menuTitle")

            val generalCategoryViewModel = GeneralCategoryViewModel()
            generalCategoryViewModel.loadCategories()
            GeneralCategoryScreen(generalCategoryViewModel, navController = navController)

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
}*/
