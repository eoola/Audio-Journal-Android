package com.wpi.audiojournal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.wpi.audiojournal.navigation.SetupNavGraph
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.screen.HomeScreen
import com.wpi.audiojournal.screen.ProgramCategoriesScreen
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
            AudioJournalTheme {
                // A surface container using the 'background' color from the theme
                /*ProgramCategoriesScreen(menuItems = listOf(
                    MenuItem("Local Newspaper"),
                    MenuItem("Retail Circulars and Sales"),
                    MenuItem("Specialty Program")))*/
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    SetupNavGraph(navController = navController)
                }
            }
        }
    }
    /*
    private fun beginFetch() {
        audioJournalServe.getCategories().enqueue(object : Callback<CategoriesDTO> {
            override fun onResponse(call: Call<CategoriesDTO>, response: Response<CategoriesDTO>) {
                val responseBody = response.body()
                for (key in responseBody?.categories?.keys!!) {
                    println(key)
                }
            }

            override fun onFailure(call: Call<CategoriesDTO?>, t: Throwable) {
                println("there was an error")
            }
        })
    }
     */
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    AudioJournalTheme {
        HomeScreen(
            menuItems = listOf(
                MenuItem("Listen Live"),
                MenuItem("Archived Programs"),
                MenuItem("Resume Last Broadcast"),
                MenuItem("Favorite Programs"),
                MenuItem("Program Schedule"),
                MenuItem("Help")
            )
        )
    }
}
