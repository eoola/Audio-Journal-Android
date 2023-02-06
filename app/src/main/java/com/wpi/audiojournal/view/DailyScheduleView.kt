package com.wpi.audiojournal.view


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp

    val menH = screenHeight-130
    val menW = screenWidth
    //val menH = screenHeight/8-10
    val butH = menH/7
    val butW = menW-10


    var buttonTextSize = butH/5

    PageSkeleton(header = title) {
        Loading(data = viewModel.schedule) { schedule ->
            LazyColumn(
                modifier = Modifier.padding(top = 5.dp, start = 5.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start,
                contentPadding = PaddingValues(vertical = 5.dp)
            ) {
                schedule[title]?.let { day ->
                    items(day.toList()) {
                        Text(
                            text = "${it.first}: ${it.second}",
                            style = MaterialTheme.typography.subtitle1,
                            fontSize = buttonTextSize.sp
                        )
                    }
                }
            }
        }
    }
}