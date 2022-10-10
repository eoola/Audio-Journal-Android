package com.wpi.audiojournal.uistates

import com.wpi.audiojournal.models.Category
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.models.Program

class GeneralProgramsUIState (
    var menuItems: List<MenuItem> = listOf(),
    var programList: List<Program> = listOf()
) {
    val Nothing: GeneralProgramsUIState
        get() {
            return Nothing
        }
}