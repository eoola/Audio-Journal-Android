package com.wpi.audiojournal.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.models.Program

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchProgramsViewModel(programList: List<Program>): ViewModel() {
    var state by mutableStateOf(MenuItemSearchState(list =programList))

    var programs = programList

    private var searchJob: Job? = null

    fun onAction(userAction: UserAction){
        when(userAction){
            is UserAction.TextFieldInput -> {
                state = state.copy(searchText = userAction.text)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500L)
                    searchProgramsInList(searchQuery = userAction.text)
                }
            }
        }

    }

    private fun searchProgramsInList(
        searchQuery: String
    ) {
        val newList = programs.filter {
            it.title.contains(searchQuery, ignoreCase = true)
        }
        state = state.copy(list = newList)
    }
}

data class MenuItemSearchState(
    var searchText:String="",
    val list: List<Program>
)

sealed class UserAction{
    data class TextFieldInput(val text:String): UserAction()
}