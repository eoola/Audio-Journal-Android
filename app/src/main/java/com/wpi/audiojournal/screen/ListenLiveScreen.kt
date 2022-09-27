package com.wpi.audiojournal.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.R

@Composable
fun ListenLiveScreen(title: String, navController: NavController) {
    //BACK BUTTON

    Button(
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
            //fontSize = 7.sp,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            maxLines = 1,
            modifier = Modifier.padding(horizontal = 0.dp, vertical = 10.dp).fillMaxSize()
            // style = MaterialTheme.typographye2.subtitl
        )
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 65.dp),
            text = title,
            style = MaterialTheme.typography.subtitle1.copy(
                //fontWeight = FontWeight.ExtraBold
            )
        )

        LazyColumn(
            modifier = Modifier.padding(top = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }


    }
}