package com.wpi.audiojournal

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.wpi.audiojournal.models.Program
import com.wpi.audiojournal.navigation.SetupNavGraph
import com.wpi.audiojournal.ui.component.GetAirtimeMap
import com.wpi.audiojournal.ui.theme.AudioJournalTheme
import com.wpi.audiojournal.ui.theme.LocalColorScheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var navController = rememberNavController()
            AudioJournalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = LocalColorScheme.current.background
                ) {
                    GetAirtimeMap()
                    SetupNavGraph(navController, suspend { intent.routeFor() }, it)
                }
            }
        }
    }
}

private suspend fun Intent?.routeFor(): String {
    return when (this?.action) {
        Intent.ACTION_VIEW -> Program.routeFor(this.getStringExtra("q"))
        else -> "home"
    }
}
