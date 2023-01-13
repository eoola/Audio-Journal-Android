package com.wpi.audiojournal.viewmodels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.wpi.audiojournal.models.Program
import com.wpi.audiojournal.repositories.AudioJournalService
import com.wpi.audiojournal.repositories.networkHandler
import kotlinx.coroutines.launch


class ProgramViewModel(application: Application) : AndroidViewModel(application) {
    var program: Program? by mutableStateOf(null)

    fun loadEpisodes(name: String) = viewModelScope.launch(networkHandler(getApplication())) {
        program = AudioJournalService.getProgram(name).body()
    }
}