package com.wpi.audiojournal.models

import com.wpi.audiojournal.navigation.Navigable
import com.wpi.audiojournal.navigation.Titled
import com.wpi.audiojournal.navigation.encode

data class Episode(
    val url: String,
    val airdate: String) : Navigable, Titled {
    override val title
        get() = airdate
    override val uri: String
        get() = "media-player/${title.encode()}/${url.encode()}"
}