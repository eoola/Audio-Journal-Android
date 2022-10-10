package com.wpi.audiojournal.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.wpi.audiojournal.models.Schedule
import com.wpi.audiojournal.uikit.Header
import com.wpi.audiojournal.uistates.GeneralScheduleUIState
import com.wpi.audiojournal.view.AppColorSchemes
import com.wpi.audiojournal.viewmodels.ScheduleViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun DailySchedule(navController: NavController, title:String?, viewModel: ScheduleViewModel = viewModel()) {

    val schedule by viewModel.uiState.collectAsState()

    var colorsObject = AppColorSchemes()
    if (title != null) {
        Header(
            title = title,
            navController = navController,
            hasBackButton = true,
            hasFavorites = false,
            menuType = title,
            colorsObj = colorsObject
        )
    }



     var tSchedule: List<Schedule> = emptyList()

    if(schedule.scheduleList.isNotEmpty()){
        tSchedule = schedule.scheduleList


        var daySchedule: List<Pair<String, String>> = emptyList()



        if (title.equals("Sunday")) {
            daySchedule = tSchedule.first().Sunday.toList()
        }

        if (title.equals("Monday")) {
            daySchedule = tSchedule.first().Monday.toList()

        }

        if (title.equals("Tuesday")) {
            daySchedule = tSchedule.first().Tuesday.toList()

        }

        if (title.equals("Wednesday")) {
            daySchedule = tSchedule.first().Wednesday.toList()
        }

        if (title.equals("Thursday")) {
            daySchedule = tSchedule.first().Thursday.toList()
        }

        if (title.equals("Friday")) {
            daySchedule = tSchedule.first().Friday.toList()
        }

        if (title.equals("Saturday")) {
            daySchedule = tSchedule.first().Saturday.toList()
        }


        //Sorta works?
        if(tSchedule.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier.padding(top = 90.dp, start = 10.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                items(items = daySchedule) { time ->
                    Text(
                        text = time.toString().replace("(", "").replace(")", "").replace(",", ":"),
                        style = MaterialTheme.typography.subtitle2
                    )
                }
            }
        }

    }
}