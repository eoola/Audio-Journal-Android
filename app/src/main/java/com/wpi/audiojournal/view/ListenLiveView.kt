package com.wpi.audiojournal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
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

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val picDim = screenWidth*.75

    PageSkeleton(header = title) {
        Loading(data = viewModel.uri) { uri ->
            Box(modifier = Modifier.size(picDim.dp, picDim.dp)){
                Image(
                    painter = painterResource(id = R.drawable.ajo_log),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .padding(50.dp)
                        .fillMaxSize()
                )
            }

            Player(uri) {
                LiveControls(it)
            }
        }
    }
}
