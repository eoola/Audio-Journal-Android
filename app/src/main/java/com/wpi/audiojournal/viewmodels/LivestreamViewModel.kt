package com.wpi.audiojournal.viewmodels

import android.app.Application
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.wpi.audiojournal.repositories.AudioJournalService
import com.wpi.audiojournal.repositories.networkHandler
import kotlinx.coroutines.launch

class LivestreamViewModel(application: Application) : AndroidViewModel(application) {
    var uri: Uri? by mutableStateOf(null)

    fun loadUri() = viewModelScope.launch(networkHandler(getApplication())) {
        uri = AudioJournalService.getLiveLink().body()
    }
}