package com.wpi.audiojournal.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.LocalImageLoader
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder
import com.wpi.audiojournal.R
import com.wpi.audiojournal.ui.theme.Blue
import com.wpi.audiojournal.ui.theme.Salmon
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SplashScreen(navController: NavController, initialRoute: suspend () -> String){

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
            Text(text = "Audio Journal", textAlign = TextAlign.Center, fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.Black, modifier = Modifier
                .semantics { this.invisibleToUser() }
                .padding(40.dp))
            /*Image(
                painter = painterResource(id = R.drawable.ic_mic_ajo),
                contentDescription = null,
                Modifier.weight(1f),
                contentScale = ContentScale.FillHeight
            )*/
            Image(painter = painterResource(id = R.drawable.ic_mic_ajo), contentDescription = "")
            /*val imageLoader = ImageLoader.Builder(LocalContext.current)
                .componentRegistry {
                    add(SvgDecoder(LocalContext.current))
                }
                .build()
            CompositionLocalProvider(LocalImageLoader provides imageLoader) {
                val painter = rememberImagePainter("./java/svg/mic.svg")

                Image(
                    painter = painter,
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RectangleShape),
                    contentScale = ContentScale.FillBounds
                )
            }*/
            CircularProgressIndicator(color = Salmon, modifier = Modifier.semantics { this.invisibleToUser() })
            Text(text = "Made in Cooperation with", textAlign = TextAlign.Center, fontSize = 30.sp, color = Color.Black, modifier = Modifier
                .semantics { this.invisibleToUser() }
                .padding(20.dp))
            Modifier.padding(40.dp)
            Image(
                painter = painterResource(id = R.drawable.loading_screen_wpi_logo),
                contentDescription = null
            )
        }
    }
    
}
