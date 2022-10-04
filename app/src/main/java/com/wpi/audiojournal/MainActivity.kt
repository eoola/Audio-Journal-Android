package com.wpi.audiojournal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.wpi.audiojournal.data.DataStuff
import com.wpi.audiojournal.navigation.SetupNavGraph
import com.wpi.audiojournal.ui.theme.AudioJournalTheme
import java.util.*

class MainActivity : ComponentActivity() {
    /*
    private val audioJournalServe by lazy {
        AudioJournalService.create()
    }
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AudioJournalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val getData = DataStuff()
                    val data= getData.initTest() //init stuff
                    //val screens = mutableListOf<Screens>()

                    SetupNavGraph(navController = navController, data)
                }
            }
        }
    }
}
