package com.wpi.audiojournal.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.exoplayer2.util.Log
import com.wpi.audiojournal.models.Program
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchProgramsViewModel(): ViewModel() {
    var text by mutableStateOf("")
    var programs by mutableStateOf(listOf<Program>())

    private var searchJob: Job? = null

    fun onAction(text: String){
        Log.i("tag", text)
        this.text = text
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            programs = Program.search(text)
        }
    }
}