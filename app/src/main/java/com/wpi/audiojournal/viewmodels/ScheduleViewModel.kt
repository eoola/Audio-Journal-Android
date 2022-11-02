package com.wpi.audiojournal.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wpi.audiojournal.repositories.AudioJournalService
import com.wpi.audiojournal.view.uistates.GeneralScheduleUIState
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


class ScheduleViewModel: ViewModel() {

 private val _uiState = MutableStateFlow(GeneralScheduleUIState())
 val uiState: StateFlow<GeneralScheduleUIState> = _uiState

  private fun loadSchedule() = viewModelScope.launch {
  val categoriesData = audioJournalService.getSchedule()


  categoriesData.enqueue(object : Callback<Map<String, Map<String, String>>?> {
   override fun onResponse(
    call: Call<Map<String, Map<String, String>>?>,
    response: Response<Map<String, Map<String, String>>?>
   ) {
    val scheduleDTO = response.body()!!
    _uiState.value.scheduleList = listOf(scheduleDTO)

    _uiState.update {
    GeneralScheduleUIState(listOf(scheduleDTO))
    }
   }

   override fun onFailure(call: Call<Map<String, Map<String, String>>?>, t: Throwable) {
    TODO("Not yet implemented")
   }
  })
 }

  init{
    loadSchedule()
}
}