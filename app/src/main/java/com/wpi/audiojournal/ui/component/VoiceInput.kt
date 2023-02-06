package com.wpi.audiojournal.ui.component

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.wpi.audiojournal.navigation.VoiceInputContract
import com.wpi.audiojournal.viewmodels.VoiceInputViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun VoiceInput(viewModel: VoiceInputViewModel= viewModel()) {
    val permissionState = rememberPermissionState(
        permission = Manifest.permission.RECORD_AUDIO
    )

    SideEffect {
        permissionState.launchPermissionRequest()
    }

    val speechRecognizerLauncher = rememberLauncherForActivityResult(
        contract = VoiceInputContract(), onResult = {
            viewModel.changeTextValue(it.toString())

        })

    Column(horizontalAlignment = Alignment.Start){
        IconButton(onClick={
            if(permissionState.status.isGranted){
                speechRecognizerLauncher.launch(Unit)
            }else{
                permissionState.launchPermissionRequest()
            }
        }){
            Icon(imageVector = Icons.Filled.Mic, contentDescription = "Voice input")
        }

        if (viewModel.state.text != null && !viewModel.state.text.equals("null")){


            Text(text = viewModel.state.text!!,
                fontSize = 20.sp
            )
        }
    }
}