package com.wpi.audiojournal.viewmodels

import androidx.lifecycle.ViewModel
import com.wpi.audiojournal.models.CategoriesDTO
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.models.ProgramsDTO
import com.wpi.audiojournal.repositories.AudioJournalService
import com.wpi.audiojournal.uistates.GeneralCategoryUIState
import com.wpi.audiojournal.uistates.GeneralProgramsUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.sql.Wrapper

private val audioJournalService by lazy {
    AudioJournalService.create()
}

class GeneralProgramsViewModel {
    private val _uiState = MutableStateFlow(GeneralProgramsUIState())
    val uiState: StateFlow<GeneralProgramsUIState> = _uiState.asStateFlow()

    fun loadPrograms(category: String) {
        val programsData = audioJournalService.getPrograms(category)

        programsData.enqueue(object : Callback<ProgramsDTO?> {
            override fun onResponse(call: Call<ProgramsDTO?>, response: Response<ProgramsDTO?>) {
                val programsDTO = response.body()!!
                _uiState.value.menuItems = programsDTO.programs.values.map { program ->
                    MenuItem(program.title, program.name, program.description)
                }
                _uiState.value.programList = programsDTO.programs.values.map { program ->
                    program
                }

                _uiState.update {
                    GeneralProgramsUIState(_uiState.value.menuItems, _uiState.value.programList)
               }


            }

            override fun onFailure(call: Call<ProgramsDTO?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

    fun onResultConsumed() {
        _uiState.tryEmit(GeneralProgramsUIState().Nothing)
    }

   /* fun loadPrograms(name: String) {
        val categoriesData = audioJournalService.getPrograms(name)
        categoriesData.enqueue(object : Callback<ProgramsDTO?> {
            override fun onResponse(call: Call<ProgramsDTO?>, response: Response<ProgramsDTO?>) {
                val categoriesDTO = response.body()!!
                uiState.value.menuItems = categoriesDTO.categories.values.map { category ->
                    MenuItem(category.title)
                }
            }

            override fun onFailure(call: Call<ProgramsDTO?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }*/
}