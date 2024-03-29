package com.wpi.audiojournal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.wpi.audiojournal.R
import com.wpi.audiojournal.ui.theme.Blue
import com.wpi.audiojournal.ui.theme.Salmon
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SplashScreenView(navController: NavController, initialRoute: suspend () -> String){

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp
    val menH = screenHeight-130
    val butH = menH/7
    var buttonTextSize = butH/5
    val picDim = screenWidth*.75

    LaunchedEffect(key1 = true){
        val delayJob = launch { delay(1000) }
        val route = initialRoute()
        delayJob.join()
        navController.popBackStack()
        navController.navigate("home")
        navController.navigate(route)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Blue)){
        Column (verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "Audio Journal", textAlign = TextAlign.Center, fontSize = (buttonTextSize * 1.5).sp, fontWeight = FontWeight.Bold, color = Color.Black, modifier = Modifier
                .semantics { this.invisibleToUser() }
                .padding(40.dp))

            Image(painter = painterResource(id = R.drawable.ic_mic_ajo), contentDescription = "", modifier = Modifier.size(picDim.dp, picDim.dp))

            CircularProgressIndicator(color = Salmon, modifier = Modifier.semantics { this.invisibleToUser() } .padding(40.dp))

            Box(modifier = Modifier.fillMaxSize()){
                Text(text = "Made in Cooperation with", textAlign = TextAlign.Center, fontSize = (buttonTextSize*1.5).sp, color = Color.Black, modifier = Modifier
                    .semantics { this.invisibleToUser() }
                    .padding(20.dp)
                    .align(Alignment.TopCenter))

                Modifier.padding(40.dp)
                Image(
                    painter = painterResource(id = R.drawable.loading_screen_wpi_logo),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.BottomCenter),
                    contentScale = ContentScale.Fit)
            }
        }
    }
}
