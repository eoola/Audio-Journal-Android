package com.wpi.audiojournal.viewmodels

import androidx.lifecycle.ViewModel
import com.wpi.audiojournal.models.EpisodeDTO
import com.wpi.audiojournal.repositories.AudioJournalService
import com.wpi.audiojournal.view.uistates.GeneralEpisodeUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val audioJournalService by lazy {
    AudioJournalService.create()
}

class GeneralEpisodeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GeneralEpisodeUIState())//mutableStateOf(GeneralCategoryUIState())//MutableStateFlow(GeneralCategoryUIState())

    val uiState: StateFlow<GeneralEpisodeUIState> = _uiState.asStateFlow() //value//StateFlow<GeneralCategoryUIState> = _uiState.value//.asStateFlow()

    fun loadEpisodes(program: String) {

        val episodesData = audioJournalService.getEpisodes(program)

        episodesData.enqueue(object : Callback<EpisodeDTO?> {
            override fun onResponse(call: Call<EpisodeDTO?>, response: Response<EpisodeDTO?>) {
                val episodesDTO = response.body()!!


                _uiState.value.episodeList = episodesDTO.episodes.values.toList()

                _uiState.update {
                    GeneralEpisodeUIState(it.episodeList)
                }
            }

            override fun onFailure(call: Call<EpisodeDTO?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}