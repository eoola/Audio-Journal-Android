package com.wpi.audiojournal.viewmodels

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wpi.audiojournal.repositories.AudioJournalService
import kotlinx.coroutines.launch

class LivestreamViewModel: ViewModel() {
    var uri: Uri? by mutableStateOf(null)

    fun loadUri() = viewModelScope.launch {
        uri = AudioJournalService.getLiveLink().body()
    }
}