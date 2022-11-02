package com.wpi.audiojournal.navigation

import android.os.Bundle
import java.net.URLDecoder
import java.net.URLEncoder

fun String.encode(): String = URLEncoder.encode(this, "UTF-8")
fun String.decode(): String = URLDecoder.decode(this, "UTF-8")
fun Bundle.getDecodedString(key: String): String? = this.getString(key)?.decode()

interface Navigable {
    val uri: String
}

interface Titled {
    val title: String
}