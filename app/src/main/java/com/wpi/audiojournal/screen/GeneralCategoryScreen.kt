package com.wpi.audiojournal.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.wpi.audiojournal.MenuItem
import com.wpi.audiojournal.R

@Composable
fun GeneralCategoryScreen(menuItems: List<MenuItem>) {
    //BACK BUTTON
    Button(
        modifier = Modifier
            .padding(
                horizontal = 1.dp,
                vertical = 1.dp
            )
            .fillMaxSize()
            .size(width = 10.dp, height = 8.dp),
        shape = CircleShape,
        onClick = { /*TODO*/ }
    ) {
        Text(
            text = "Back",
            style = MaterialTheme.typography.subtitle2
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = stringResource(R.string.programCategoriesTitle),
            style = MaterialTheme.typography.subtitle1.copy(
                //fontWeight = FontWeight.ExtraBold
            )
        )


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
                    onClick = { /*TODO*/ }
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