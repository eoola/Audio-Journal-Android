package com.wpi.audiojournal.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.wpi.audiojournal.navigation.Navigable
import com.wpi.audiojournal.navigation.Titled
import com.wpi.audiojournal.ui.theme.LocalColorScheme
import com.wpi.audiojournal.viewmodels.VoiceInputViewModel


@Composable
fun <T> Menu (menuItems: List<T>, navController: NavController, viewModel: VoiceInputViewModel = viewModel()) where T : Navigable, T : Titled {

    //Row(horizontalArrangement = Arrangement.Start){
    VoiceInput(viewModel)
    //}


    LazyColumn {
        rainbow(menuItems) { menuItem, color ->
            Button(
                modifier = Modifier
                    .padding(
                        horizontal = 24.dp,
                        vertical = 5.dp
                    )
                    .fillMaxSize()
                    .size(width = 100.dp, height = 85.dp),
                colors = ButtonDefaults.buttonColors(color),
                shape = CircleShape,
                border = BorderStroke(2.dp, LocalColorScheme.current.borders),
                onClick = {
                    navController.navigate(menuItem.uri)
                }
            ) {
                Text(
                    text = menuItem.title,
                    color = LocalColorScheme.current.content,
                    style = MaterialTheme.typography.subtitle1
                )
                if(viewModel.state!!.text.equals(menuItem.title)){
                    navController.navigate(menuItem.uri)
                }
            }

        }

    }



}