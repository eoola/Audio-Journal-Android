package com.wpi.audiojournal.viewmodels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.wpi.audiojournal.models.Category
import com.wpi.audiojournal.repositories.AudioJournalService
import com.wpi.audiojournal.repositories.networkHandler
import kotlinx.coroutines.launch

class ArchiveViewModel(application: Application) : AndroidViewModel(application) {
    var categories: List<Category>? by mutableStateOf(null)

    fun loadCategories() = viewModelScope.launch(networkHandler(getApplication())) {
        categories = AudioJournalService.getCategories().body() ?: listOf()
    }
}