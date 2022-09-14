package com.wpi.audiojournal

import android.icu.text.CaseMap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(menuItems: List<MenuItem>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = stringResource(R.string.audioJournalTitle),
            style = MaterialTheme.typography.subtitle1.copy(
                fontWeight = FontWeight.ExtraBold
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

        IconButton(onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(R.drawable.color_palette_icon),
                contentDescription = "Color Palette Icon")
        }
    }
}
