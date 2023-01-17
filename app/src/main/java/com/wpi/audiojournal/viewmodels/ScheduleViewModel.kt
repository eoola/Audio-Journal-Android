package com.wpi.audiojournal.viewmodels


import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.wpi.audiojournal.repositories.AudioJournalService
import com.wpi.audiojournal.repositories.networkHandler
import kotlinx.coroutines.launch


class ScheduleViewModel(application: Application) : AndroidViewModel(application) {
    var schedule: Map<String, Map<String, String>>? by mutableStateOf(null)
    fun loadSchedule() = viewModelScope.launch(networkHandler(getApplication())) {
        AudioJournalService.getSchedule().body()?.let {
            schedule = it
        }
    }
}