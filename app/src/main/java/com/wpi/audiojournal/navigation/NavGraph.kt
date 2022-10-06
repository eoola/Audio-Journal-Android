package com.wpi.audiojournal.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.screen.HomeScreen
import com.wpi.audiojournal.screen.ProgramCategoriesScreen
import com.wpi.audiojournal.screen.SplashScreen
import com.wpi.audiojournal.data.DataStuff
import com.wpi.audiojournal.models.CategoriesDTO
import com.wpi.audiojournal.models.MenuItemFactory
import com.wpi.audiojournal.screen.*

import com.wpi.audiojournal.view.ProgramDetailView
import com.wpi.audiojournal.view.*

@Composable
fun SetupNavGraph(navController: NavHostController, items: MenuItemFactory, data: CategoriesDTO) {
    NavHost(navController = navController, startDestination = "loading") {


        composable("loading") {
            SplashScreen(navController = navController)
        }
        composable("home") {
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
        composable("Archived Programs") {
            var menuItems = items.getMenuItems("Archived Programs")
            ArchiveCategoriesView(menuItems = menuItems, navController = navController)
            /*
            ProgramCategoriesScreen(menuItems = listOf(
                MenuItem("Local Newspaper"),
                MenuItem("Retail Circulars and Sales"),
                MenuItem("Specialty Program")), navController=navController)*/
        }

        composable("program option/{menuTitle}") { navBackStackEntry ->
            val menuItemTitle = navBackStackEntry.arguments?.getString("menuTitle")
            val title = menuItemTitle.toString()
            var menuItems = items.getMenuItems(title)
            ProgramOptionsView(menuItems = menuItems, navController = navController, title = title)
        }

        composable("program detail/{menuTitle}") { navBackStackEntry ->
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
    }
}

        /*
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
