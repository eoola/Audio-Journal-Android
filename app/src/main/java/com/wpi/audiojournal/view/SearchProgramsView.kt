package com.wpi.audiojournal.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.wpi.audiojournal.ui.component.Menu
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.viewmodels.SearchProgramsViewModel

@Composable
fun SearchProgramsView(navController: NavController, title: String, q: String?) {
    val viewModel: SearchProgramsViewModel = viewModel()
    LaunchedEffect(LocalContext.current) {
        q?.let {
            viewModel.onAction(it)
        }
    }
    PageSkeleton(header = title) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.text,
            onValueChange = { viewModel.onAction(it) },
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 20.sp
            ),

            leadingIcon ={
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon"
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Black.copy(
                    alpha = ContentAlpha.medium
                ),
                focusedBorderColor = Color.Black,
                cursorColor = Color.Black
            ),

            placeholder = {
                Text(
                    text = "Search...",
                    color = Color.Black.copy(alpha = ContentAlpha.medium)
                )
            },

            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {}
            )
        )

        Menu(menuItems = viewModel.programs, navController = navController)
    }
}