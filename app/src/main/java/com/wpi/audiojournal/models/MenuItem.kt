package com.wpi.audiojournal.models

import com.wpi.audiojournal.navigation.Navigable
import com.wpi.audiojournal.navigation.Titled

data class MenuItem (override val title: String, override val uri: String) : Navigable, Titled
