package com.wpi.audiojournal.view


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.viewmodels.ScheduleViewModel

@Composable
fun DailyScheduleView(title: String, viewModel: ScheduleViewModel = viewModel()) {

    val schedule by viewModel.uiState.collectAsState()

    PageSkeleton(header = title) {
        LazyColumn(
            modifier = Modifier.padding(top = 90.dp, start = 10.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            schedule.scheduleList.takeIf { it.isNotEmpty() }?.first()?.get(title)?.let {
                items(items = it.toList()) { time ->
                    Text(
                        text = time.toString().replace("(", "").replace(")", "").replace(",", ":"),
                        style = MaterialTheme.typography.subtitle2
                    )
                }
            }
        }
    }
}