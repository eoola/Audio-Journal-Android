package com.wpi.audiojournal.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wpi.audiojournal.models.Category
import com.wpi.audiojournal.repositories.AudioJournalService
import kotlinx.coroutines.launch

class ArchiveViewModel: ViewModel() {
    var categories: List<Category>? by mutableStateOf(null)

    fun loadCategories() = viewModelScope.launch {
        categories = AudioJournalService.getCategories().body() ?: listOf()
    }
}