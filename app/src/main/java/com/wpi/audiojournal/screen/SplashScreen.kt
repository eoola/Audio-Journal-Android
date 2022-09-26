package com.wpi.audiojournal.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wpi.audiojournal.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(key1 = true){
        delay(3000)
        navController.navigate("home")
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(R.color.blue))){
        Column (verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Audio Journal", textAlign = TextAlign.Center, fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Modifier.padding(40.dp)
            Image(
                painter = painterResource(id = R.drawable.loading_screen_mic),
                contentDescription = "Microphone",
                Modifier.weight(1f),
                contentScale = ContentScale.FillHeight
                )
            CircularProgressIndicator()
            Text(text = "Made in Cooperation with", textAlign = TextAlign.Center, fontSize = 30.sp)
            Modifier.padding(40.dp)
            Image(
                painter = painterResource(id = R.drawable.loading_screen_wpi_logo),
                contentDescription = "WPI Logo"
            )
        }
    }
    
}