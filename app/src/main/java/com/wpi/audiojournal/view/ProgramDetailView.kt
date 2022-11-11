package com.wpi.audiojournal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.wpi.audiojournal.R
import com.wpi.audiojournal.ui.component.Loading
import com.wpi.audiojournal.ui.component.Menu
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.viewmodels.ProgramViewModel
import com.wpi.audiojournal.viewmodels.FavoritesViewModel

@Composable
fun ProgramDetailView(navController: NavController, title: String, name: String, favViewModel: FavoritesViewModel, viewModel: ProgramViewModel = viewModel()){
    LaunchedEffect(name) {
        viewModel.loadEpisodes(name)
    }

    PageSkeleton(header = title) {
        Loading(data = viewModel.program) { program ->
            Text(text = program.description)
            FavoritesSection(navController, title, favViewModel)
            program.episodes?.let {
                Menu(menuItems = it, navController = navController)
            }
        }
    }


}

@Composable
fun FavoritesSection(navController: NavController, title: String, favViewModel: FavoritesViewModel){

    val gray = R.drawable.favorites_gray
    val yellow = R.drawable.favorites_yellow

    Row(modifier = Modifier.padding(20.dp)){
        Text(
            modifier = Modifier.padding(top=15.dp),
            text = "Favorite: ",
//                color = colorResource(id = AppColorSchemes().getContent()),
        )

        var marked by rememberSaveable {
            mutableStateOf(favViewModel.isFavorite(title))
        }

        IconButton(onClick = {
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