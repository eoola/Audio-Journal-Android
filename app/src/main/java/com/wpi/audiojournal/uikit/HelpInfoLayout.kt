package com.wpi.audiojournal.uikit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.wpi.audiojournal.R
import com.wpi.audiojournal.view.AppColorSchemes




@Composable
fun HelpInfo(helpCategory:String, colorsObj: AppColorSchemes,){

    val configuration = LocalConfiguration.current

    val helpData = HelpData()

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    val contentColor = colorResource(id =colorsObj.getContent())
    val bColor = colorResource(id =colorsObj.getBorder())
    val boxColor = colorResource(id = colorsObj.getBackgroundBox())
    //should not be bColor
    //alignment, border... etc


    Box(modifier = Modifier
        .background(boxColor)
        .width(screenWidth - 20.dp)
        .border(5.dp, bColor).padding(vertical = 10.dp)


    ){

        Column() {
            Image(
                painter = painterResource(id = helpData.getResource(helpCategory)),
                contentDescription = helpData.getContentDesc(helpCategory),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(width = 200.dp, height = 100.dp).align(Alignment.CenterHorizontally)
                //.fillMaxWidth(0.5F)
            )
            Text(
                modifier = Modifier.padding( horizontal = 10.dp, vertical = 10.dp),

                text = helpData.getDescription(helpCategory),
                color = contentColor,
                style = MaterialTheme.typography.subtitle1
            )
            if(helpCategory.equals("Audio Journal Info")){
                Image(
                    painter = painterResource(id = R.drawable.main_logo),
                    contentDescription = "audio journal main logo",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.size(width = 200.dp, height = 100.dp)
                        .align(Alignment.CenterHorizontally)
                    //.fillMaxWidth(0.5F)
                )
            }
        }



    }
}

class HelpData(){
    fun getResource(helpCategory: String):Int{
        if(helpCategory.contains("Audio Journal Info")){
            return R.drawable.audio_logo_72rgb

        }else if(helpCategory.contains("Media Player") || helpCategory.contains("Browsing Menu") || helpCategory.contains("Search Bar") ){

            return R.drawable.search_icon
        }else if(helpCategory.contains("Search By Voice")){
            return R.drawable.mic_icon

        }else if(helpCategory.contains("Favoriting Programs")){
            return R.drawable.favorites_yellow

        }else if(helpCategory.contains("Color Palette Changer")){
            return R.drawable.color_palette_icon

        }
        else{
            return -1
        }
    }

    fun getContentDesc(helpCategory: String):String{
        if(helpCategory.contains("Audio Journal Info")){
            return "AJO Logo"

        }else if(helpCategory.contains("Media Player") || helpCategory.contains("Browsing Menu") || helpCategory.contains("Search Bar") ){

            return "Magnifying glass"
        }else if(helpCategory.contains("Search By Voice")){
            return "voice control microphone"

        }else if(helpCategory.contains("Favoriting Programs")){
            return "favorite icon yellow"

        }else if(helpCategory.contains("Color Palette Changer")){
            return "color palette icon"

        }
        else{
            return ""
        }
    }


    fun getDescription(helpCategory: String):String{
        if(helpCategory.contains("Audio Journal Info")){
            return "Audio Journal\'s mission in Central Massachusetts is to connect individuals with a visual impairment, or an inability to access print material, to their communities through broadcasting of local news, information, and entertainment, with exclusive programs and content.\n\n" +
                    "This app is one of many different methods of accessing Audio Journal broadcasts. Contact Audio Journal for assistance in choosing the best listening method for you.\n\n" +
                    "Audio Journal\n799 West Boylston Street\n" +
                    "Worcester,MA 01606\n508-797-1117\ninfo@audiojournal.org\nhttp://audiojournal.org\n\nFor app support, please email\ninfo@audiojournal.org"
        }else if(helpCategory.contains("Media Player")){
            return "The media player is the screen that appears when audio is played \n\nIt contains a play/pause button, skip buttons, speed button, scroll bar and airplay button \n\n" +
                    "The skip button allow you to skip forward or backwards by 30 or 60 seconds \n\n" +
                    "The speed button allows you to change the playback speed to 1.5 times the speed or 2 times the speed \n\n" +
                    "The airplay button allows you to connect to other devices through bluetooth"
        }
        else if(helpCategory.contains("Browsing Menu")){
            return "The browsing menu is the primary method of finding programs \n\n" +
                    "To start searching for programs, press \"Archived Programs\" button on the main menu. \n\n" +
                    "Next, press one of the program category buttons. \n\n" +
                    "Next, press the button of the program you want to listen to. \n\n" +
                    "Finally, select the individual broadcast you want to listen to. The broadcasts are sorted by date."
        }
        else if(helpCategory.contains("Search Bar")){
            return "The search bar is useful if you already know the name of the pogram you want to hear, or to find news from a specific community.\n\n" +
                    "To start searching for programs, press the \"Archived Programs\" button on the main menu.\n\n" +
                    "Press the \"Search Programs\" button.\n\n" +
                    "Next, press the search bar to bring up the keyboard\n\n" +
                    "Type in the program name, keyword, or town in the search bar. \n\n" +
                    "Buttons for the programs you searched for will appear below the search bar."
        }
        else if(helpCategory.contains("Search By Voice")){
            return "TBC"
        }
        else if(helpCategory.contains("Favoriting Programs")){
            return "Identifying as a favorite allows you to access it by pressing the \"Favorite Programs\" button on the main menu\n\n" +
                    "On the individual program\'s listing page , press the \"Favorite\" button to mark it as favorite. \n\n" +
                    "To remove a program from your favorites list, press the \"Favorite\" button again on the individual program\'s listing page."
        }
        else if(helpCategory.contains("Color Palette Changer")){
            return "The color palette changer lets you select a color combination that works best for you. \n\n" +
                    "Pressing the color palette button in the bottom left corner of main menu to cycle through color options for the buttons, background, and other user interface elements."
        }
        else{
            return "ERROR"
        }

    }
}




