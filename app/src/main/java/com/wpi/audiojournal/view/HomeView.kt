package com.wpi.audiojournal.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.wpi.audiojournal.R
import com.wpi.audiojournal.StoreData
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.ui.component.Menu
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.ui.theme.ColorScheme
import com.wpi.audiojournal.ui.theme.LocalColorScheme
import com.wpi.audiojournal.ui.theme.nextColorScheme
import com.wpi.audiojournal.viewmodels.FavoritesViewModel

@Composable
fun HomeView(
    menuItems: List<MenuItem>,
    navController: NavController,
    setColorScheme: (ColorScheme) -> Unit
) {
    BackHandler {}
    val colors = LocalColorScheme.current
    val viewModel = FavoritesViewModel(StoreData(LocalContext.current))
    PageSkeleton(header = "Audio Journal") {
        Menu(menuItems = menuItems, navController = navController)
        Box(modifier = Modifier.size(100.dp, 100.dp) ){
            IconButton(modifier = Modifier.size(120.dp), onClick = { setColorScheme(nextColorScheme(colors, viewModel)) }) {
                Image(
                    painter = painterResource(R.drawable.color_palette_icon),
                    contentDescription = "Color Palette Icon",
                    contentScale = ContentScale.Fit
                )
            }
        }

    }
}