package com.wpi.audiojournal.viewmodels

import androidx.lifecycle.ViewModel
import com.wpi.audiojournal.models.CategoriesDTO
import com.wpi.audiojournal.repositories.AudioJournalService
import com.wpi.audiojournal.view.uistates.GeneralCategoryUIState
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

class GeneralCategoryViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(GeneralCategoryUIState())//mutableStateOf(GeneralCategoryUIState())//MutableStateFlow(GeneralCategoryUIState())

    val uiState: StateFlow<GeneralCategoryUIState> = _uiState.asStateFlow() //value//StateFlow<GeneralCategoryUIState> = _uiState.value//.asStateFlow()

    fun loadCategories() {

        val categoriesData = audioJournalService.getCategories()

        categoriesData.enqueue(object : Callback<CategoriesDTO?> {
            override fun onResponse(
                call: Call<CategoriesDTO?>,
                response: Response<CategoriesDTO?>
            ) {
                val categoriesDTO = response.body()!!

                _uiState.value.categoryList = categoriesDTO.categories.values.toList()

                _uiState.update {
                        GeneralCategoryUIState(it.categoryList)
                }
            }

            override fun onFailure(call: Call<CategoriesDTO?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}