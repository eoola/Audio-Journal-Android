package com.wpi.audiojournal.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.wpi.audiojournal.R
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.uikit.Header
import com.wpi.audiojournal.viewmodels.GeneralCategoryViewModel

@Composable

fun GeneralCategoryScreen(menuItems: List<MenuItem>, navController: NavController) {
    //Header(title = "Program Categories", navController = rememberNavController() )


   /* LazyColumn(
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
                onClick = { navController.navigate("category/${menuItem.title}") }
            ) {
                Text(
                    text = menuItem.title,
                    style = MaterialTheme.typography.subtitle2
                )
            }

        }
    }*/
}