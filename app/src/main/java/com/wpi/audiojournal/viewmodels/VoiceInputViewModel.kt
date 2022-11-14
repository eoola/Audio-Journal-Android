package com.wpi.audiojournal.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wpi.audiojournal.models.VoiceInputText
import kotlinx.coroutines.launch

class VoiceInputViewModel: ViewModel() {
    var state by mutableStateOf(VoiceInputText())
        private set

    fun changeTextValue(text:String){
        viewModelScope.launch {
            state= state.copy(
                text = text
            )
        }
    }
}