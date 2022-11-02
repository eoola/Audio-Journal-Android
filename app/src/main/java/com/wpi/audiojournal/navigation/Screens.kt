package com.wpi.audiojournal.navigation

sealed class Screens (val route: String){

    object homeScreen : Screens("Home")
    object loadingScreen: Screens("loading")
    object programScheduleScreen: Screens("Program Schedule")
    object dynamicProgramScheduleView: Screens("Schedule")
    object archivedScreen: Screens("Archived Programs")
    object programOptionScreen: Screens("program-option")
    object programDetailScreen: Screens("program-detail")
    object listenLiveScreen: Screens("Listen Live")
    object mediaPlay: Screens("media-player")
    object helpScreen: Screens("Help")
    object helpInfo: Screens("help-info")

    //object screen: Screens(name)
}
