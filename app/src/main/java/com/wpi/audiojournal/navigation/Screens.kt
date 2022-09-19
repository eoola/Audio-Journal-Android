package com.wpi.audiojournal.navigation

sealed class Screens (val route: String){

    object homeScreen : Screens("home")
    object loadingScreen: Screens("loading")
    object programCategoriesScreen: Screens("Archived Programs")
}