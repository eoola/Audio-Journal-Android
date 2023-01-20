package com.wpi.audiojournal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.wpi.audiojournal.R
import com.wpi.audiojournal.ui.component.Loading
import com.wpi.audiojournal.ui.component.Menu
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.ui.component.airtimeMap
import com.wpi.audiojournal.ui.theme.LocalColorScheme
import com.wpi.audiojournal.viewmodels.ProgramViewModel
import com.wpi.audiojournal.viewmodels.FavoritesViewModel

@Composable
fun ProgramDetailView(navController: NavController, title: String, name: String, favViewModel: FavoritesViewModel, viewModel: ProgramViewModel = viewModel()){
    LaunchedEffect(name) {
        viewModel.loadEpisodes(name)
    }

    PageSkeleton(header = title) {
        Loading(data = viewModel.program) { program ->
            val airtime = airtimeMap.get(program.title)
            var strAirtime = ""
            if (airtime != null) {

                for(day in airtime.keys){
                    strAirtime = strAirtime +" "+ day
                    for ( time in airtime.get(day)!!){
                        strAirtime = strAirtime +" "+ time
                    }
                    strAirtime = strAirtime
                }
            }
            Text(text = "Airtime:"+strAirtime,fontSize = 18.sp)
            Text(text = program.description, fontSize = 18.sp)
            FavoritesSection(navController, title, favViewModel)
            program.episodes?.let {
                Menu(menuItems = it, navController = navController)
            }
        }
    }


}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FavoritesSection(navController: NavController, title: String, favViewModel: FavoritesViewModel){

    val gray = R.drawable.favorites_gray
    val yellow = R.drawable.favorites_yellow

    Row(modifier = Modifier.padding(20.dp)){
        Text(
            modifier = Modifier.padding(top=15.dp).semantics { this.invisibleToUser() },
            text = "Favorite: ",
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
                .height(50.dp)
                .width(50.dp)){
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