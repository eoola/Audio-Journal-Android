package com.wpi.audiojournal.viewmodels

import com.wpi.audiojournal.models.CategoriesDTO
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.models.ProgramsDTO
import com.wpi.audiojournal.repositories.AudioJournalService
import com.wpi.audiojournal.uistates.GeneralCategoryUIState
import com.wpi.audiojournal.uistates.GeneralProgramsUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val audioJournalService by lazy {
    AudioJournalService.create()
}

class GeneralProgramsViewModel {
    private val _uiState = MutableStateFlow(GeneralProgramsUIState())
    val uiState: StateFlow<GeneralProgramsUIState> = _uiState.asStateFlow()

    fun loadPrograms(name: String) {
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

    }
}