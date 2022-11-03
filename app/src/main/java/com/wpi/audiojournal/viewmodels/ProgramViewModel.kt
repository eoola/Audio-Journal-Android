package com.wpi.audiojournal.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wpi.audiojournal.models.Program
import com.wpi.audiojournal.repositories.AudioJournalService
import kotlinx.coroutines.launch


class ProgramViewModel : ViewModel() {
    var program: Program? by mutableStateOf(null)

    fun loadEpisodes(name: String) = viewModelScope.launch {
        program = AudioJournalService.getProgram(name).body()
    }
}