package com.wpi.audiojournal.uistates

import com.wpi.audiojournal.models.Category
import com.wpi.audiojournal.models.Episode
import com.wpi.audiojournal.models.MenuItem

class GeneralEpisodeUIState (
    var menuItems: List<MenuItem> = listOf(),
    var episodeList: List<Episode> = listOf()
)