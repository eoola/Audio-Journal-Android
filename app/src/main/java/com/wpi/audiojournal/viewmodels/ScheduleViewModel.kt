package com.wpi.audiojournal.viewmodels


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wpi.audiojournal.repositories.AudioJournalService
import kotlinx.coroutines.launch


class ScheduleViewModel: ViewModel() {
    var schedule: Map<String, Map<String, String>>? by mutableStateOf(null)
    fun loadSchedule() = viewModelScope.launch {
        AudioJournalService.getSchedule().body()?.let {
            schedule = it
        }
    }
}