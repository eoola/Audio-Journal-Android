package com.wpi.audiojournal

import android.net.Uri
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.Timeline
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit
import kotlin.math.max

@Composable
fun Player(uri: Uri, content: @Composable (Player) -> Unit) {
    val context = LocalContext.current
    val exoPlayer = remember (context, uri) {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(uri))

            prepare()
            seekToDefaultPosition()
            playWhenReady = true
        }
    }

    DisposableEffect(context) {
        onDispose {
            exoPlayer.release()
        }
    }

    content(exoPlayer)
}


@Composable
fun Controls(player: Player) {
    var position by remember { mutableStateOf(0L) }
    var maxPosition by remember { mutableStateOf(0L) }
    var isPlaying by remember { mutableStateOf(false) }

    fun seek (long: Long) {
        val window = Timeline.Window()
        player.currentTimeline.getWindow(0, window)

        if (window.isSeekable) {
            player.seekTo(long)
        }
    }

    fun seek (float: Float) {
        seek(maxPosition.times(float).toLong())
    }

    fun time (long: Long): String {
        val hours = TimeUnit.MILLISECONDS.toHours(long).toInt() % 24
        val minutes = TimeUnit.MILLISECONDS.toMinutes(long).toInt() % 60
        val seconds = TimeUnit.MILLISECONDS.toSeconds(long).toInt() % 60
        return when {
            hours > 0 -> String.format("%d:%02d:%02d", hours, minutes, seconds)
            minutes > 0 -> String.format("%02d:%02d", minutes, seconds)
            seconds > 0 -> String.format("00:%02d", seconds)
            else -> {
                "00:00"
            }
        }
    }


    LaunchedEffect(Unit) {
        while(true) {
            position = player.currentPosition
            maxPosition = max(player.bufferedPosition, player.duration)
            delay(500)
        }
    }

    DisposableEffect(player) {
        val listener = object : Player.Listener {
            override fun onEvents(player: Player, events: Player.Events) {
                super.onEvents(player, events)
                position = player.currentPosition
                isPlaying = player.isPlaying
                maxPosition = max(player.bufferedPosition, player.duration)
            }
        }
        player.addListener(listener)
        onDispose {
            player.removeListener(listener)
        }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(time(position))
            Text(time(maxPosition))
        }
        Slider(
            modifier = Modifier.fillMaxWidth(),
            value = (position.toFloat()/maxPosition.toFloat()).takeUnless { it.isNaN() } ?: 0F,
            onValueChange = ::seek
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            IconButton(onClick = { seek(position.minus(10000)) }) {
                Icon(Icons.Default.ChevronLeft, "Rewind Ten Seconds")
            }
            IconButton(onClick = { if (isPlaying) player.pause() else player.play()}) {
                if (isPlaying)
                    Icon(Icons.Default.Pause, "Pause")
                else
                    Icon(Icons.Default.PlayArrow, "Play")
            }
            IconButton(onClick = { seek(position.plus(10000)) }) {
                Icon(Icons.Default.ChevronRight, "Skip Ten Seconds")
            }
        }

    }
}

@Composable
fun LiveControls(player: Player) {
    var isPlaying by remember { mutableStateOf(false) }

    DisposableEffect(player) {
        val listener = object : Player.Listener {
            override fun onEvents(player: Player, events: Player.Events) {
                super.onEvents(player, events)
                isPlaying = player.isPlaying
            }
        }
        player.addListener(listener)
        onDispose {
            player.removeListener(listener)
        }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            IconButton(onClick = { if (isPlaying) player.pause() else player.play()}) {
                if (isPlaying)
                    Icon(Icons.Default.Pause, "Pause")
                else
                    Icon(Icons.Default.PlayArrow, "Play")
            }
        }

    }
}