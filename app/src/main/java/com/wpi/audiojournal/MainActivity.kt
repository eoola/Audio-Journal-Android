package com.wpi.audiojournal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
//import com.wpi.audiojournal.data.DataStuff
import com.wpi.audiojournal.navigation.SetupNavGraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.models.MenuItemFactory
import com.wpi.audiojournal.repositories.AudioJournalService
import com.wpi.audiojournal.screen.HomeScreen
import com.wpi.audiojournal.screen.GeneralCategoryScreen
import com.wpi.audiojournal.screen.GeneralProgramsScreen
import com.wpi.audiojournal.screen.ProgramCategoriesScreen

import com.wpi.audiojournal.ui.theme.AudioJournalTheme
import com.wpi.audiojournal.viewmodels.GeneralCategoryViewModel
import com.wpi.audiojournal.viewmodels.GeneralEpisodeViewModel
import com.wpi.audiojournal.viewmodels.GeneralProgramsViewModel
import java.util.*

class MainActivity : ComponentActivity() {
    /*
    private val audioJournalServe by lazy {
        AudioJournalService.create()
    }
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val catViewModel = GeneralCategoryViewModel()
        val progViewModel = GeneralProgramsViewModel()
        val epiViewModel = GeneralEpisodeViewModel()
        //val factory= MenuItemFactory(catViewModel, progViewModel)
        //factory.initializeFactory()

        var progLoaded = false
        setContent {

           // factory.initializeFactory()

            AudioJournalTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()




                    //factory.initializeFactory()
                        //val getData = DataStuff()
                   // getData.initTest()


                    //val api = AudioJournalService.create()
                    //val data = getData.getCat()//api.getCategories().execute().body()//getData.getCat()
                    //init stuff
                    //val screens = mutableListOf<Screens>()

                    //if (data != null) {
                    SetupNavGraph(navController = navController, catViewModel, progViewModel, epiViewModel, progLoaded)
                   // }
                }
            }
        }
    }
}
