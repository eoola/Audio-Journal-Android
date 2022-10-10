package com.wpi.audiojournal.view

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.wpi.audiojournal.models.Category
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.models.MenuType
import com.wpi.audiojournal.screen.MenuView
import com.wpi.audiojournal.viewmodels.GeneralCategoryViewModel

@Composable
fun ArchiveCategoriesView( navController: NavController, categoryViewModel:GeneralCategoryViewModel){//(menuItems: List<MenuItem>, navController: NavController) {

    //val categoryViewModel = GeneralCategoryViewModel()
    categoryViewModel.loadCategories()
    val categories by categoryViewModel.uiState.collectAsState()
    var menuItems: List<MenuItem> = listOf()
    //var catList: List<Category> = listOf()
   // val catHash = HashMap<String, String>()


    if(categories.menuItems != null){
        menuItems= categories.menuItems
    }

    /*if(categories.categoryList != null){
        catList = categories.categoryList
        for(c in catList){
            catHash.put(c.title, c.name)
        }
    }

    Log.d("TEST","${catHash.size.toString()}HASH")*/



    Log.d("TEST", menuItems.size.toString())

    MenuView(
        screenType = "Archived",
        title = "Program Categories",
        navController = navController,
        hasBackButton = true,
        hasFavorites = false,
        menuItems = menuItems,
        hasColorPalette = false,
        hasSearch = true,
        headerSpace = 100
       // navData= catHash
    )
}