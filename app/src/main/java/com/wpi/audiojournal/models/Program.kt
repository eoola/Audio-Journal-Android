package com.wpi.audiojournal.models

import com.wpi.audiojournal.navigation.Navigable
import com.wpi.audiojournal.navigation.Titled
import com.wpi.audiojournal.navigation.encode

class Program(
    override val title: String,
    val name: String) : Titled, Navigable {
    override val uri: String
        get() = "program-detail/${title.encode()}/${name.encode()}"
}
