package com.wpi.audiojournal.viewmodels

import androidx.lifecycle.ViewModel
import com.wpi.audiojournal.models.CategoriesDTO
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.repositories.AudioJournalService
import com.wpi.audiojournal.uistates.GeneralCategoryUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val audioJournalService by lazy {
    AudioJournalService.create()
}

class GeneralCategoryViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(GeneralCategoryUIState())
    val uiState: StateFlow<GeneralCategoryUIState> = _uiState.asStateFlow()

    fun loadCategories() {
        val categoriesData = audioJournalService.getCategories()

        categoriesData.enqueue(object : Callback<CategoriesDTO?> {
            override fun onResponse(
                call: Call<CategoriesDTO?>,
                response: Response<CategoriesDTO?>
            ) {
                val categoriesDTO = response.body()!!
                uiState.value.menuItems = categoriesDTO.categories.values.map { category ->
                    MenuItem(category.title)
                }
            }

            override fun onFailure(call: Call<CategoriesDTO?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}