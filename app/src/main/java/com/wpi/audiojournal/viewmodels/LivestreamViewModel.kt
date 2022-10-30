package com.wpi.audiojournal.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wpi.audiojournal.repositories.AudioJournalService
import com.wpi.audiojournal.uistates.LivestreamUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val audioJournalService by lazy {
    AudioJournalService.create()
}

class LivestreamViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(LivestreamUIState())
    val uiState: StateFlow<LivestreamUIState> = _uiState

    private fun loadLink() = viewModelScope.launch {
        val liveLinkData = audioJournalService.getLiveLink()


        liveLinkData.enqueue(object : Callback<String?> {
            override fun onResponse(
                call: Call<String?>,
                response: Response<String?>
            ) {
                val liveLink = response.body()!!
                _uiState.value.link = listOf(liveLink)

                _uiState.update {
                    LivestreamUIState(listOf(liveLink))
                }
            }

            override fun onFailure(call: Call<String?>, t: Throwable) {

            }
        })
    }

    init{
        loadLink()
    }
}