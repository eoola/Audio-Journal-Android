package com.wpi.audiojournal.viewmodels


import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.models.Schedule
import com.wpi.audiojournal.repositories.AudioJournalService
import com.wpi.audiojournal.uistates.GeneralScheduleUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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


  categoriesData.enqueue(object : Callback<Schedule?> {
   override fun onResponse(
    call: Call<Schedule?>,
    response: Response<Schedule?>
   ) {
    val scheduleDTO = response.body()!!
    _uiState.value.scheduleList = listOf(scheduleDTO)

    _uiState.update {
    GeneralScheduleUIState(listOf(scheduleDTO))
    }
   }

   override fun onFailure(call: Call<Schedule?>, t: Throwable) {

   }
  })
 }

  init{
    loadSchedule()
}
}