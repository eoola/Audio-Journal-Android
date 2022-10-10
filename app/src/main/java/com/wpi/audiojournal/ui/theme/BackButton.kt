package com.wpi.audiojournal.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun BackButton(navController: NavController) = Button(
    modifier = Modifier
        .padding(
            horizontal = 5.dp,
            vertical = 5.dp
        )
        //.fillMaxSize()
        .size(width = 60.dp, height = 50.dp),
    shape = RoundedCornerShape(30),
    onClick = { navController.popBackStack() }
) {
    Text(
        text = "Back",
        style = MaterialTheme.typography.body1,
        textAlign = TextAlign.Center,
        fontSize = 12.sp,
        maxLines = 1,
        modifier = Modifier
            .padding(horizontal = 0.dp, vertical = 10.dp)
            .fillMaxSize()
    )
}