package com.wpi.audiojournal

//import com.wpi.audiojournal.data.DataStuff

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.google.android.exoplayer2.C
import com.wpi.audiojournal.models.Category
import com.wpi.audiojournal.models.Program
import com.wpi.audiojournal.navigation.SetupNavGraph
import com.wpi.audiojournal.ui.component.GetAirtimeMap
import com.wpi.audiojournal.ui.component.Loading
import com.wpi.audiojournal.ui.theme.AudioJournalTheme
import com.wpi.audiojournal.ui.theme.LocalColorScheme
import com.wpi.audiojournal.viewmodels.ArchiveViewModel
import com.wpi.audiojournal.viewmodels.CategoryViewModel
import com.wpi.audiojournal.viewmodels.ScheduleViewModel
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities

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
                    color = LocalColorScheme.current.background
                ) {
                    GetAirtimeMap()


                    val navController = rememberNavController()




                    SetupNavGraph(navController = navController, setColorScheme = it)


                }
            }
        }
    }


}
