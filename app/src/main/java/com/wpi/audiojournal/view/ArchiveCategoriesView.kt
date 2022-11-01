package com.wpi.audiojournal.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.wpi.audiojournal.ui.component.Menu
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.viewmodels.GeneralCategoryViewModel

@Composable
fun ArchiveCategoriesView( navController: NavController, categoryViewModel: GeneralCategoryViewModel = viewModel()){

    categoryViewModel.loadCategories()
    val categories by categoryViewModel.uiState.collectAsState()

    PageSkeleton(header = "Program Categories") {
        Menu(menuItems = categories.categoryList, navController = navController)
    }
}