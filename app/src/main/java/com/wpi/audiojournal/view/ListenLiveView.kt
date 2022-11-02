package com.wpi.audiojournal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wpi.audiojournal.R
import com.wpi.audiojournal.ui.component.LiveControls
import com.wpi.audiojournal.ui.component.Loading
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.ui.component.Player
import com.wpi.audiojournal.viewmodels.LivestreamViewModel

@Composable
fun ListenLiveView(title: String, viewModel: LivestreamViewModel = viewModel()) {
    LaunchedEffect(LocalContext.current) {
        viewModel.loadUri()
    }

    PageSkeleton(header = title) {
        Loading(data = viewModel.uri) { uri ->
            Image(
                painter = painterResource(id = R.drawable.loading_screen_mic),
                contentDescription = "Album Art",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .padding(50.dp)
                    .fillMaxWidth(0.5F)
            )
            Player(uri) {
                LiveControls(it)
            }
        }
    }
}
