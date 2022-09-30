package com.wpi.audiojournal.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.wpi.audiojournal.models.MenuItem

@Composable
fun GeneralProgramsScreen(menuItems: List<MenuItem>, navController: NavController, title:String, airtime: String, description:String) {
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
            fontSize = 25.sp,
            style = MaterialTheme.typography.subtitle1.copy(
                //fontWeight = FontWeight.ExtraBold
            )
        )

        Text(
            modifier = Modifier,
            text = "Airtime: $airtime"

        )
        //Text air time

        Text(
            modifier = Modifier,
            text = description

            )

        Text(
            modifier = Modifier,
            text = "Favorite: "
        )
        //Text description
        //Text before button
        //Favorites button


        LazyColumn(
            modifier = Modifier.padding(top = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = menuItems) { menuItem ->
                Button(
                    modifier = Modifier
                        .padding(
                            horizontal = 24.dp,
                            vertical = 10.dp
                        )
                        .fillMaxSize()
                        .size(width = 100.dp, height = 80.dp),
                    shape = CircleShape,
                    onClick = {
                        // if(menuItem.title.equals("Archived Programs")){
                        //   navController.navigate("Archived Programs")
                        //}


                    }
                ) {
                    Text(
                        text = menuItem.title,
                        style = MaterialTheme.typography.subtitle2
                    )
                }
            }
        }
    }
}