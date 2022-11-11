package com.wpi.audiojournal.view

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.wpi.audiojournal.ui.component.Controls
import com.wpi.audiojournal.ui.component.Player
import com.wpi.audiojournal.R
import com.wpi.audiojournal.ui.component.PageSkeleton

@Composable
fun MediaPlayerView(title: String, uriString: String, playTime: Long) {
    PageSkeleton(header = title) {
        Image(
            painter = painterResource(id = R.drawable.loading_screen_mic),
            contentDescription = "Album Art",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(50.dp)
                .fillMaxWidth(0.5F)
        )
        Player (Uri.parse(uriString.replace("http:", "https:"))) {
            Controls(it, title, playTime, uriString)
        }
    }
}