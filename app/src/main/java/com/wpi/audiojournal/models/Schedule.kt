package com.wpi.audiojournal.models

import com.google.gson.annotations.SerializedName

data class Schedule(
    @SerializedName("Sunday")
    val Sunday: Map<String, String>,
    @SerializedName("Monday")
    val Monday: Map<String, String>,
    @SerializedName("Tuesday")
    val Tuesday: Map<String, String>,
    @SerializedName("Wednesday")
    val Wednesday: Map<String, String>,
    @SerializedName("Thursday")
    val Thursday: Map<String, String>,
    @SerializedName("Friday")
    val Friday: Map<String, String>,
    @SerializedName("Saturday")
    val Saturday: Map<String, String>
)
