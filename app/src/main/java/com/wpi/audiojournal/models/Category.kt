package com.wpi.audiojournal.models

import com.wpi.audiojournal.navigation.Navigable
import com.wpi.audiojournal.navigation.Titled
import com.wpi.audiojournal.navigation.encode

data class Category (
    override val title: String,
    val name: String,
    val description: String
    ) : Navigable, Titled {
        override val uri
            get() = "program-option/${title.encode()}/${name.encode()}"
    }
