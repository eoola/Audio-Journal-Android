package com.wpi.audiojournal.viewmodels

import androidx.lifecycle.ViewModel
import com.wpi.audiojournal.models.ProgramsDTO
import com.wpi.audiojournal.repositories.AudioJournalService
import com.wpi.audiojournal.view.uistates.GeneralProgramsUIState
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

class GeneralProgramsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GeneralProgramsUIState())
    val uiState: StateFlow<GeneralProgramsUIState> = _uiState.asStateFlow()

    fun loadPrograms(category: String) {
        val programsData = audioJournalService.getPrograms(category)

        programsData.enqueue(object : Callback<ProgramsDTO?> {
            override fun onResponse(call: Call<ProgramsDTO?>, response: Response<ProgramsDTO?>) {
                val programsDTO = response.body()!!

                _uiState.value.programList = programsDTO.programs.values.toList()

                _uiState.update {
                    GeneralProgramsUIState(_uiState.value.programList)
               }
            }

            override fun onFailure(call: Call<ProgramsDTO?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}