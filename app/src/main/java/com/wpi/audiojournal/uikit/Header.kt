package com.wpi.audiojournal.uikit

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.wpi.audiojournal.R

@Composable
fun Header(title: String, navController: NavController, hasBackButton: Boolean = true) {
    Column() {
        if (hasBackButton) {
            Button(
                modifier = Modifier
                    .padding(
                        horizontal = 5.dp,
                        vertical = 5.dp
                    )
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
        }

        Column(
            //modifier = Modifier.fillMaxSize(),
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = title,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}