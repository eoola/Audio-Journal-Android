package com.wpi.audiojournal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.wpi.audiojournal.R
import com.wpi.audiojournal.ui.component.*
import com.wpi.audiojournal.viewmodels.ProgramViewModel
import com.wpi.audiojournal.viewmodels.FavoritesViewModel

@Composable
fun ProgramDetailView(navController: NavController, title: String, name: String, favViewModel: FavoritesViewModel, viewModel: ProgramViewModel = viewModel()){
    LaunchedEffect(name) {
        viewModel.loadEpisodes(name)
    }

    var textSize = 16

    PageSkeleton(header = title) {

        Loading(data = viewModel.program) { program ->
                var airtime = airtimeMap.get(program.title)
                var strAirtime = ""

                if(airtime == null || airtime.equals("")){

                    for (i in airtimeMap.keys){
                        if (i.contains(program.title)){
                            airtime = airtimeMap.get(i)
                        }
                    }
                }

                if (airtime != null) {

                    for(day in airtime.keys){
                        strAirtime = strAirtime +" "+ day
                        for ( time in airtime.get(day)!!){
                            strAirtime = strAirtime +" "+ time
                        }
                        strAirtime = strAirtime
                    }
                }

                    program.episodes?.let {
                        DPPage(
                            menuItems = it,
                            navController = navController,
                            textSize = textSize,
                            title = title,
                            favViewModel = favViewModel,
                            strAirtime = strAirtime,
                            program = program
                        )
                    }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FavoritesSection(navController: NavController, title: String, favViewModel: FavoritesViewModel){

    val gray = R.drawable.favorites_gray
    val yellow = R.drawable.favorites_yellow

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val menH = screenHeight-130
    val butH = menH/7
    var buttonTextSize = butH/5

    Row(modifier = Modifier.padding(10.dp)){
        Text(
            modifier = Modifier
                .padding(top = buttonTextSize.dp)
                .semantics { this.invisibleToUser() },
            text = "Favorite: ",
            fontSize = buttonTextSize.sp
        )

        var marked by rememberSaveable {
            mutableStateOf(favViewModel.isFavorite(title))
        }

        IconButton(modifier = Modifier.clearAndSetSemantics {
            contentDescription = if(marked) "This program is currently favorited. Double tap this button to unfavorite this program" else "This program is currently" +
                    "not favorited. Double tap this button to favorite this program"
        },
            onClick = {
            marked = !marked

            if(marked){
                val linkMenuTitle = navController.currentBackStackEntry?.arguments?.getString("menuTitle")
                val linkName = navController.currentBackStackEntry?.arguments?.getString("name")
                val link = "program-detail/$linkMenuTitle/$linkName"
                favViewModel.addFavorite(title, link)
            }
            else{
                favViewModel.deleteFavorite(title)
            }
        })
        {
            Box(modifier = Modifier
                .height((buttonTextSize*3).dp)
                .width((buttonTextSize*3).dp)){
                Image(
                    painter = painterResource(
                        id = if (marked) {
                            yellow
                        } else {
                            gray
                        }
                    ),
                    contentDescription = "Favorites",
                    contentScale = ContentScale.Fit
                )
            }

        }
    }
}