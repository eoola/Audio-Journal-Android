package com.wpi.audiojournal.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Card

import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
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
import com.wpi.audiojournal.ui.theme.LocalColorScheme
import com.wpi.audiojournal.viewmodels.ProgramViewModel
import com.wpi.audiojournal.viewmodels.FavoritesViewModel

@Composable
fun ProgramDetailView(navController: NavController, title: String, name: String, favViewModel: FavoritesViewModel, viewModel: ProgramViewModel = viewModel()){
    LaunchedEffect(name) {
        viewModel.loadEpisodes(name)
    }



    val configuration = LocalConfiguration.current

    val screenWidth = configuration.screenWidthDp

    var textSize = 16





    val scrollState = rememberScrollState()


    PageSkeleton(header = title) {


        Loading(data = viewModel.program) { program ->
            //Box(modifier = Modifier
             //   .scrollable(state = scrollState, orientation = Orientation.Vertical)){

                var airtime = airtimeMap.get(program.title)
                var strAirtime = ""

                if(airtime == null || airtime.equals("")){

                    for (i in airtimeMap.keys){
                        Log.d("TEST", i)
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

                    //Text(text = "Airtime:"+strAirtime,fontSize = textSize.sp)



                    //Text(text = program.description, fontSize = textSize.sp)

                    //FavoritesSection(navController, title, favViewModel)

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

                        //Menu(menuItems = it, navController = navController)
                    }







                //}





            //}
        }

    }





}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FavoritesSection(navController: NavController, title: String, favViewModel: FavoritesViewModel){

    val gray = R.drawable.favorites_gray
    val yellow = R.drawable.favorites_yellow

    Row(modifier = Modifier.padding(10.dp)){
        Text(
            modifier = Modifier
                .padding(top = 15.dp)
                .semantics { this.invisibleToUser() },
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