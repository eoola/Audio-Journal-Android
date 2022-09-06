package com.wpi.audiojournal

import android.icu.text.CaseMap
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import com.wpi.audiojournal.ui.theme.RoundButton

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Title()
        Column(
            modifier = Modifier.fillMaxSize(),
            // color = MaterialTheme.colors.background
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            RoundButton(
                text = "Listen Live",
                onClick = { /*TODO*/ },
                borderColor = Color.Black, //COLORS ARE PLACE HOLDERS
                backgroundColor = Color.White,
                contentColor = Color.Black
            )

            RoundButton(
                text = "Archived Programs",
                onClick = { /*TODO*/ },
                borderColor = Color.Black, //COLORS ARE PLACE HOLDERS
                backgroundColor = Color.White,
                contentColor = Color.Black
            )

            RoundButton(
                text = "Resume Last Broadcast",
                onClick = { /*TODO*/ },
                borderColor = Color.Black, //COLORS ARE PLACE HOLDERS
                backgroundColor = Color.White,
                contentColor = Color.Black
            )

            RoundButton(
                text = "Favorite Programs",
                onClick = { /*TODO*/ },
                borderColor = Color.Black, //COLORS ARE PLACE HOLDERS
                backgroundColor = Color.White,
                contentColor = Color.Black
            )

            RoundButton(
                text = "Program Schedule",
                onClick = { /*TODO*/ },
                borderColor = Color.Black, //COLORS ARE PLACE HOLDERS
                backgroundColor = Color.White,
                contentColor = Color.Black
            )

            RoundButton(
                text = "Help",
                onClick = { /*TODO*/ },
                borderColor = Color.Black, //COLORS ARE PLACE HOLDERS
                backgroundColor = Color.White,
                contentColor = Color.Black
            )



            ScreenPalette()
        }
    }
}

@Composable
fun Title(){
    Text("Audio Journal")
}



//This is for the palette changer
@Composable
fun ScreenPalette() {

    Button(onClick = { /*TODO*/ }) {
        //Icon(painter = Painter., contentDescription = "Color Palette Button")
    }
}

