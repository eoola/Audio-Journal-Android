package com.wpi.audiojournal.ui.component

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wpi.audiojournal.viewmodels.ScheduleViewModel

val airtimeMap = HashMap<String, HashMap<String, MutableList<String>>>()

@Composable
fun GetAirtimeMap(viewModel: ScheduleViewModel = viewModel()){
    viewModel.loadSchedule()
    val data = viewModel.schedule

    if (data != null) {

        for(day in data.keys){ //go trough each day

            val timeMap = data.get(day) //Get the time and program pair

            if (timeMap != null) {

                for(time in timeMap.keys){ //Go through each time
                    val prog = timeMap.get(time)

                    if(airtimeMap.get(prog).isNullOrEmpty()){ // if program not in map
                        //Add the new hashmap with key as day and list of times with 1 time
                        val airtime = hashMapOf<String, MutableList<String>>()
                        val timeList = mutableListOf<String>()
                        timeList.add(time)
                        airtime.put(day, timeList)

                        if (prog != null) {
                            airtimeMap.put(prog, airtime)
                        }
                    }
                        else{ //if program in map
                        val progAirtime =  airtimeMap.get(prog)

                        if(progAirtime?.get(day).isNullOrEmpty()){ //if program not the same day
                            //Add day to map
                            val timeList = mutableListOf<String>()
                            timeList.add(time)
                            progAirtime?.put(", "+day, timeList)
                        }
                        else{ //if program ha sthe same day, different time
                            //add time to list
                            if (progAirtime != null) {
                                progAirtime.get(day)?.add(", "+ time)
                            }
                        }
                    }

                }
            }
        }
    }

}