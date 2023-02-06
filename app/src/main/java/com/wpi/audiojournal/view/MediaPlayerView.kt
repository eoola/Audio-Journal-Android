package com.wpi.audiojournal.view

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.wpi.audiojournal.ui.component.Controls
import com.wpi.audiojournal.ui.component.Player
import com.wpi.audiojournal.R
import com.wpi.audiojournal.ui.component.PageSkeleton

@Composable
fun MediaPlayerView(title: String, uriString: String, playTime: Long) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val picDim = screenWidth*.75

    PageSkeleton(header = title) {
        Box(modifier = Modifier.size(picDim.dp,picDim.dp)){
            Image(
                painter = painterResource(id = R.drawable.ajo_log),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .padding(50.dp)
                    .fillMaxSize()
            )
        }

        Player (Uri.parse(uriString.replace("http:", "https:"))) {
            Controls(it, title, playTime, uriString)
        }
    }
}