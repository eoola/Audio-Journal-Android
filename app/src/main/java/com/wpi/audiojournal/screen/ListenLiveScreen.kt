package com.wpi.audiojournal.screen

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.wpi.audiojournal.view.AppColorSchemes

val uri: Uri = Uri.parse("https://stream-47.zeno.fm/nvbenz3c19duv")
@Composable
fun ListenLiveScreen(title: String, navController: NavController) {

    var colorsObj = AppColorSchemes()

    val backColor = colorsObj.getRainbowColor("Back", -1)
    val contentColor = colorResource(id =colorsObj.getContent())
    val bColor = colorResource(id =colorsObj.getBorder())
    var stroke = 0
    if(bColor != null){
        stroke = 4
    }
    Button(
        modifier = Modifier
            .padding(
                horizontal = 5.dp,
                vertical = 5.dp
            )
            .size(width = 60.dp, height = 50.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id =backColor)),
        shape = RoundedCornerShape(30),
        border = BorderStroke(stroke.dp, bColor),

        onClick = { navController.popBackStack() }
    ) {
        Text(
            text = "Back",
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            maxLines = 1,
            color = contentColor,
            modifier = Modifier
                .padding(horizontal = 0.dp, vertical = 10.dp)
                .fillMaxSize()
        )
    }


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

    DisposableEffect(LocalContext.current) {
        onDispose {
            exoPlayer.pause()
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