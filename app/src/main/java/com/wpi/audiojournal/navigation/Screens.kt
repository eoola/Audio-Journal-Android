package com.wpi.audiojournal.navigation

sealed class Screens (val route: String){

    object homeScreen : Screens("Home")
    object loadingScreen: Screens("loading")
    object archivedScreen: Screens("Archived Programs")
    object programOptionScreen: Screens("program option")
    object programDetailScreen: Screens("program detail")




    //object screen: Screens(name)






}