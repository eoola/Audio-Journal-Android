package com.wpi.audiojournal

//import com.wpi.audiojournal.data.DataStuff

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.wpi.audiojournal.navigation.SetupNavGraph
import com.wpi.audiojournal.ui.theme.AudioJournalTheme

class MainActivity : ComponentActivity() {
    /*
    private val audioJournalServe by lazy {
        AudioJournalService.create()
    }
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
                    SetupNavGraph(navController = navController)
                   // }
                }
            }
        }
    }
}
