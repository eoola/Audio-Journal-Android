package com.wpi.audiojournal.screen

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.wpi.audiojournal.R
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player

val uri: Uri = Uri.parse("https://stream-47.zeno.fm/nvbenz3c19duv")
@Composable
fun ListenLiveScreen(title: String, navController: NavController) {

    val context = LocalContext.current
    val playing = remember { mutableStateOf(false) }

    val exoPlayer = remember(context) {
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.Builder()
                .setUri(uri)
                .build()

            addListener(object : Player.Listener {
                override fun onIsPlayingChanged(isPlaying: Boolean) {
                    playing.value = isPlaying
                    super.onIsPlayingChanged(isPlaying)
                }
            })

            setMediaItem(mediaItem)
            playWhenReady = true
            prepare()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 65.dp),
            text = title,
            style = MaterialTheme.typography.subtitle1.copy(
                //fontWeight = FontWeight.ExtraBold
            )
        )

        Image(
            painter = painterResource(id = R.drawable.loading_screen_mic),
            contentDescription = "Album Art",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(50.dp)
                .fillMaxWidth(0.5F)
        )
        Button(onClick = toggle(exoPlayer)) {
            if (playing.value) {
                Icon(Icons.Default.Pause, contentDescription = "Pause")
            } else {
                Icon(Icons.Default.PlayArrow, contentDescription = "Play")
            }

        }
    }
}

fun toggle(player: ExoPlayer): () -> Unit {
    player.apply {
        return fun () {
            if (isPlaying) {
                pause()
            } else {
                seekToDefaultPosition()
                play()
            }
        }
    }
}