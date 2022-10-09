package com.wpi.audiojournal.models

class MenuItem(
    var title: String,
    val name: String? = null,
    val description: String?= null,
    val url: String?=null,
    val airdate: String?=null,
    val action: (() -> Void)? = null
)
