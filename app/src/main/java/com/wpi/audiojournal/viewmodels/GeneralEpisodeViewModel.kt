package com.wpi.audiojournal.viewmodels

import android.util.Log
import com.wpi.audiojournal.models.CategoriesDTO
import com.wpi.audiojournal.models.EpisodeDTO
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.repositories.AudioJournalService
import com.wpi.audiojournal.uistates.GeneralCategoryUIState
import com.wpi.audiojournal.uistates.GeneralEpisodeUIState
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

class GeneralEpisodeViewModel {
    private val _uiState = MutableStateFlow(GeneralEpisodeUIState())//mutableStateOf(GeneralCategoryUIState())//MutableStateFlow(GeneralCategoryUIState())

    val uiState: StateFlow<GeneralEpisodeUIState> = _uiState.asStateFlow() //value//StateFlow<GeneralCategoryUIState> = _uiState.value//.asStateFlow()

    fun loadEpisodes(program: String) {

        val episodesData = audioJournalService.getEpisodes(program)

        episodesData.enqueue(object : Callback<EpisodeDTO?> {
            override fun onResponse(call: Call<EpisodeDTO?>, response: Response<EpisodeDTO?>) {
                val episodesDTO = response.body()!!
                _uiState.value.menuItems = episodesDTO.episodes.values.map { episode ->
                    MenuItem(url = episode.url, title = episode.airdate, airdate = episode.airdate)

                }
                //_uiState.value.menuItems.forEachIndexed { index, element ->
                //    element.title = "${episodesDTO.episodes.keys}"
                //}
                episodesDTO.episodes.keys.forEachIndexed{index, element ->
                    _uiState.value.menuItems.get(index).title = element

                }

                _uiState.value.episodeList = episodesDTO.episodes.values.map { episode -> episode
                }

                _uiState.update {
                    GeneralEpisodeUIState(it.menuItems, it.episodeList)
                }



            }

            override fun onFailure(call: Call<EpisodeDTO?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })



    }
}