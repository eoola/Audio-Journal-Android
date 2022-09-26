package com.wpi.audiojournal.models

class MenuItem(
    val title: String,
    val action: (() -> Void)? = null
)
