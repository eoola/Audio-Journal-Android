package com.wpi.audiojournal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wpi.audiojournal.ui.theme.AudioJournalTheme
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            SetupNavGraph(navController = navController)
        }
    }
}

data class MenuItem(val title: String)

@Composable
private fun MainApp() {
    HomeScreen(menuItems = listOf(
        MenuItem("Listen Live"),
        MenuItem("Archived Programs"),
        MenuItem("Resume Last Broadcast"),
        MenuItem("Favorite Programs"),
        MenuItem("Program Schedule"),
        MenuItem("Help")
    ))
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