package com.wpi.audiojournal.screen


import android.annotation.SuppressLint
import android.util.Log
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
import com.wpi.audiojournal.uikit.Header
import com.wpi.audiojournal.uistates.GeneralScheduleUIState
import com.wpi.audiojournal.viewmodels.ScheduleViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun DailySchedule(navController: NavController, title:String?, viewModel: ScheduleViewModel = viewModel()) {

    val schedule by viewModel.uiState.collectAsState()


//    var test = viewModel.uiState.value
//
//    LaunchedEffect(true){
//        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
//        launch{
//            viewModel.uiState.collectLatest {
//                test = it
//            }
//        }
//    }


    Log.d("Test", schedule.scheduleList.toString())
//    Log.d("Sunday", schedule.scheduleList.)
//    Log.d("Test", test.scheduleList.toString())

//    schedule.scheduleList.map {
//        Log.d("Sunday", it.Sunday.toString())
//    }

//    schedule.scheduleList.map {
//        Log.d("Sunday", it.Sunday.toList().get(1).toString())
//    }

    if (title != null) {
        Header(title = title, navController = navController)
    }


    //If the return type (type of data) is a Schedule containing a list of strings, should be easy to plug and pop as seen below
//    val test: List<String> = listOf("12:00", "aaa")
//    val testTwo: List<String> = listOf("1:00", "ddd")
//
//    val dataList: Schedule = Schedule(Sunday = test, Monday = testTwo, Tuesday = test, Wednesday = test, Thursday = test, Friday = test, Saturday = test)
//
//    var daySchedule: List<String> = schedule.scheduleList.map { day ->
//        day.Sunday.toString()
//    }

//    if(title.equals("Sunday")){
//        daySchedule = dataList.Sunday
//    }
//
//    if(title.equals("Monday")){
//        daySchedule = dataList.Monday
//    }
//
//    if(title.equals("Tuesday")){
//        daySchedule = dataList.Tuesday
//    }
//
//    if(title.equals("Wednesday")){
//        daySchedule = dataList.Wednesday
//    }
//
//    if(title.equals("Thursday")){
//        daySchedule = dataList.Thursday
//    }
//
//    if(title.equals("Friday")){
//        daySchedule = dataList.Friday
//    }
//
//    if(title.equals("Saturday")){
//        daySchedule = dataList.Saturday
//    }


//    LazyColumn(
//        modifier = Modifier.padding(top = 90.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        items(items = daySchedule) { schedule ->
//            Text(
//                text = schedule,
//                style = MaterialTheme.typography.subtitle2,
//                maxLines = 1
//            )
//        }
//    }
}



//Sorta works?
//LazyColumn(
//modifier = Modifier.padding(top = 90.dp),
//verticalArrangement = Arrangement.Center,
//horizontalAlignment = Alignment.CenterHorizontally
//) {
//    items(items = daySchedule) { schedule ->
//        for (i in 0..26) {
//            Text(
//                text = schedule.get(i).toString(),
//                style = MaterialTheme.typography.subtitle2,
//            )
//        }
//    }
//}

///////////////////////////////////////////////////////////////////////////////////////////
//
//    if(viewModel.getScheduleData.value?.isNotEmpty() == true){
//
//        LazyColumn {
//            viewModel.getScheduleData.value?.let {
//                items(it.size, viewModel.getScheduleData.value)
//        }
//    }


//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//            LazyColumn{
//
//            }
//
//    }
//}