package com.wpi.audiojournal.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.uikit.Header

@Composable
fun ProgramCategoriesScreen(menuItems: List<MenuItem>, navController: NavController) {
    Column() {
        Header(title = "Program Categories", navController = navController)

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                modifier = Modifier.size(width = 300.dp, height = 40.dp),
                shape = CircleShape,
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Search Programs",
                    style = MaterialTheme.typography.subtitle2
                )
            }
            LazyColumn(
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
}