package com.wpi.audiojournal.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun <T> Loading (data: T?, content: @Composable (data: T) -> Unit) = data?.let {
    content(data)
} ?: Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
    CircularProgressIndicator()
}