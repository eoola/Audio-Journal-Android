package com.wpi.audiojournal.models

import com.wpi.audiojournal.R

data class InfoDescription(val screenTitle:String, val screenID:String, val icon:Int, val desc: String, val icon2:Int? = null) {
}




val AudioJournalInfo = InfoDescription(
    "Audio Journal Info",
    "audio-journal-info",
    R.drawable.audio_logo_72rgb,
    "Audio Journal\'s mission in Central Massachusetts is to connect individuals with a visual impairment, or an inability to access print material, to their communities through broadcasting of local news, information, and entertainment, with exclusive programs and content.\n\n" +
            "This app is one of many different methods of accessing Audio Journal broadcasts. Contact Audio Journal for assistance in choosing the best listening method for you.\n\n" +
            "Audio Journal\n799 West Boylston Street\n" +
            "Worcester,MA 01606\n508-797-1117\ninfo@audiojournal.org\nhttp://audiojournal.org\n\nFor app support, please email\ninfo@audiojournal.org",
    R.drawable.main_logo

)


val MediaPlayerInfo = InfoDescription(
    "Using the media player",
    "media-player",
    R.drawable.search_icon,
    "The media player is the screen that appears when audio is played \n\nIt contains a play/pause button, skip buttons, speed button, scroll bar and airplay button \n\n" +
            "The skip button allow you to skip forward or backwards by 30 or 60 seconds \n\n" +
            "The speed button allows you to change the playback speed to 1.5 times the speed or 2 times the speed \n\n" +
            "The airplay button allows you to connect to other devices through bluetooth"

)
val BrowsingMenuInfo= InfoDescription(
    "Finding Programs with the Browsing Menu",
    "browsing-menu",
    R.drawable.search_icon,
    "The browsing menu is the primary method of finding programs \n\n" +
            "To start searching for programs, press \"Archived Programs\" button on the main menu. \n\n" +
            "Next, press one of the program category buttons. \n\n" +
            "Next, press the button of the program you want to listen to. \n\n" +
            "Finally, select the individual broadcast you want to listen to. The broadcasts are sorted by date."

)
val SearchBarInfo = InfoDescription(
    "Finding Programs with the Search Bar",
    "search-bar",
    R.drawable.search_icon,
    "The search bar is useful if you already know the name of the pogram you want to hear, or to find news from a specific community.\n\n" +
            "To start searching for programs, press the \"Archived Programs\" button on the main menu.\n\n" +
            "Press the \"Search Programs\" button.\n\n" +
            "Next, press the search bar to bring up the keyboard\n\n" +
            "Type in the program name, keyword, or town in the search bar. \n\n" +
            "Buttons for the programs you searched for will appear below the search bar."



)
val SearchByVoiceInfo = InfoDescription(
    "Finding Programs with Search By Voice",
    "search-by-voice",
    R.drawable.mic_icon,
    "TBC"


)
val FavoritingInfo = InfoDescription(
    "Favoriting Programs",
    "favoriting",
    R.drawable.favorites_yellow,
    "Identifying as a favorite allows you to access it by pressing the \"Favorite Programs\" button on the main menu\n\n" +
            "On the individual program\'s listing page , press the \"Favorite\" button to mark it as favorite. \n\n" +
            "To remove a program from your favorites list, press the \"Favorite\" button again on the individual program\'s listing page."


)

val ColorChangerInfo = InfoDescription(
    "Color Palette Changer",
    "color-changer",
    R.drawable.color_palette_icon,
    "The color palette changer lets you select a color combination that works best for you. \n\n" +
            "Pressing the color palette button in the bottom left corner of main menu to cycle through color options for the buttons, background, and other user interface elements."

)

val helpInfoMap = hashMapOf<String, InfoDescription>(
    Pair(AudioJournalInfo.screenID, AudioJournalInfo),
    Pair(MediaPlayerInfo.screenID, MediaPlayerInfo),
    Pair(BrowsingMenuInfo.screenID, BrowsingMenuInfo),
    Pair(SearchBarInfo.screenID, SearchBarInfo),
    Pair(SearchByVoiceInfo.screenID, SearchByVoiceInfo),
    Pair(FavoritingInfo.screenID, FavoritingInfo),
    Pair(ColorChangerInfo.screenID, ColorChangerInfo)
)




