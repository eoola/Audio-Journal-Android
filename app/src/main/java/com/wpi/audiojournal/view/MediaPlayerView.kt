package com.wpi.audiojournal.screen

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.TimeBar
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import com.wpi.audiojournal.R
import com.wpi.audiojournal.view.AppColorSchemes
import retrofit2.http.Url
import java.net.URI
import java.net.URL


@Composable
fun MediaPlayerView(title: String, navController: NavController, uriString: String) {
    //val uriMed: Url = URL()
    //uriMed = uriString
    //val uriMed = RawResourceDataSource.

    //val uriMed: Uri= Uri.parse(uriString)

    Log.d("TEST", "Link: $uriString")

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

    //val dataSourceFactory = DefaultDataSource.Factory(context)
    //val extractorsFactory = DefaultExtractorsFactory()
    val exoPlayer = remember(context) {
        ExoPlayer.Builder(context).build().apply {
            //mediaDataSourceFactory = buildDataSourceFactory(true)
            //extractorsFactory = DefaultExtractorsFactory()
            //val mediaItem = MediaItem.Builder().setUrl//.fromUri(uriString)
            val mediaItem = MediaItem.fromUri(uriString)//"https://audiojournal.org/wireready/audio/cn-augrfmlbsu/09946_CN-AuGrfMlbSu.mp3")
            //MediaSource mediaSource = new ExtractorMediaSource

            /*val mediaSource = ProgressiveMediaSource
                .Factory(dataSourceFactory, extractorsFactory)
                .createMediaSource(mediaItem)*/



            addListener(object : Player.Listener {
                override fun onIsPlayingChanged(isPlaying: Boolean) {
                    playing.value = isPlaying
                    super.onIsPlayingChanged(isPlaying)
                }
            })
            //this.prepare(mediaSource)
            //setMediaSource(mediaSource)

            setMediaItem(mediaItem)
            playWhenReady = true
            prepare()

        }
    }

    val duration = exoPlayer.contentDuration

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
        Button(onClick = toggleMed(exoPlayer)) {
            if (playing.value) {
                Icon(Icons.Default.Pause, contentDescription = "Pause")
            } else {
                Icon(Icons.Default.PlayArrow, contentDescription = "Play")
            }

        }

        Slider(
            modifier = Modifier.fillMaxWidth(),
            value = 1f,
            onValueChange = { value: Float -> },
            valueRange = 0f..1f,
            colors =
            SliderDefaults.colors(
                //thumbColor =
                //activeTickColor = Purple200
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // show total video time
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Duration"
                //text ="${duration/3600}:${duration%60/60}:${duration%3600}"
                //color = Purple200
            )
        }
    }



}

fun toggleMed(player: ExoPlayer): () -> Unit {
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

/*private fun extractMediaSourceFromUri(uri: Uri): MediaSource {
    val userAgent = Util.getUserAgent(this, "Exo")
    return ExtractorMediaSource.Factory(DefaultDataSourceFactory(this, userAgent))
        .setExtractorsFactory(DefaultExtractorsFactory()).createMediaSource(uri)
}*/