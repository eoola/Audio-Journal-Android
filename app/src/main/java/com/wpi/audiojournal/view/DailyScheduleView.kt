package com.wpi.audiojournal.view


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wpi.audiojournal.ui.component.Loading
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.ui.theme.LocalColorScheme
import com.wpi.audiojournal.viewmodels.ScheduleViewModel

@Composable
fun DailyScheduleView(title: String, viewModel: ScheduleViewModel = viewModel()) {
    LaunchedEffect(LocalContext.current) {
        viewModel.loadSchedule()
    }

    PageSkeleton(header = title) {
        Loading(data = viewModel.schedule) { schedule ->
            LazyColumn(
                modifier = Modifier.padding(top = 90.dp, start = 10.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                schedule[title]?.let { day ->
                    items(day.toList()) {
                        Text(
                            text = "${it.first}: ${it.second}",
                            color = LocalColorScheme.current.pageContent,
                            style = MaterialTheme.typography.subtitle2
                        )
                    }
                }
            }
        }
    }
}