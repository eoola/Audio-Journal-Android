package com.wpi.audiojournal.ui.component

import android.Manifest
import android.Manifest.permission.RECORD_AUDIO
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.wpi.audiojournal.navigation.VoiceInputContract
import com.wpi.audiojournal.viewmodels.VoiceInputViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


//@OptIn(ExperimentalPermissionsAPI::class)
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

    //Column(modifier = Modifier,
    //horizontalAlignment = Alignment.Start) {
    Column(horizontalAlignment = Alignment.Start){
        IconButton(onClick={
            if(permissionState.status.isGranted){
                speechRecognizerLauncher.launch(Unit)
            }else{
                permissionState.launchPermissionRequest()
            }
        }){
            //Text(text = "Speak")
            Icon(imageVector = Icons.Filled.Mic, contentDescription = "Voice input")
        }

        if (viewModel.state.text != null && !viewModel.state.text.equals("null")){


            Text(text = viewModel.state.text!!,
                fontSize = 20.sp
            )
            //return viewModel.state.text!!
        }

        
    }

        
    //}



}