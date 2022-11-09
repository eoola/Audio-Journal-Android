package com.wpi.audiojournal.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.wpi.audiojournal.viewmodels.SearchProgramsViewModel
import com.wpi.audiojournal.viewmodels.UserAction

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Search(
    navController: NavController,
    viewModel: SearchProgramsViewModel
){
    val state = viewModel.state

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    SearchBar(onInputValueChange = { newText ->
        viewModel.onAction(
            UserAction.TextFieldInput(newText)
        )

    },
        searchText = state.searchText,
        onSearchClicked = {
            keyboardController?.hide()
            focusManager.clearFocus()
        }
    )


    if(!state.searchText.equals("")){
        Menu(menuItems = state.list, navController = navController)
    }


}



@Composable
fun SearchBar(
    onInputValueChange: (String) -> Unit,
    searchText: String,
    onSearchClicked: () -> Unit
){
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = searchText,
        onValueChange = {
                        onInputValueChange(it)
        },
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
            onSearch = {onSearchClicked()}
        )





    )

}

