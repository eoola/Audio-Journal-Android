package com.wpi.audiojournal.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(){

    Box(
        modifier = Modifier.fillMaxSize(),
    )
    {
        Text(
            text="HOME"
        )
    }
}


@Composable
@Preview(showBackground=true)
fun HomeScreenPreview(){
    HomeScreen()
}