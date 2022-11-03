package com.wpi.audiojournal.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wpi.audiojournal.models.Program
import com.wpi.audiojournal.repositories.AudioJournalService
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {
    var programs: List<Program>? by mutableStateOf(null)

    fun loadPrograms(category: String) = viewModelScope.launch {
        programs = AudioJournalService.getPrograms(category).body() ?: listOf()

    }
}