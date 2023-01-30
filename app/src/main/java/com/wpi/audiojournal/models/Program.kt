package com.wpi.audiojournal.models

import com.wpi.audiojournal.navigation.Navigable
import com.wpi.audiojournal.navigation.Titled
import com.wpi.audiojournal.navigation.encode
import com.wpi.audiojournal.repositories.AudioJournalService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

data class Program(
    override val title: String,
    val name: String,
    val description: String,
    @Mapped
    val episodes: List<Episode>?
) : Titled, Navigable {
    override val uri: String
        get() = "program-detail/${title.encode()}/${name.encode()}"

    companion object {

        private suspend fun fetchAll() = withContext (Dispatchers.IO) {
            try {
                AudioJournalService.getCategories().body()!!.flatMap {
                    AudioJournalService.getPrograms(it.name).body()!!
                }
            } catch (e: Exception) {
                listOf()
            }
        }

        private var allRaw = listOf<Program>()

        suspend fun getAll(): List<Program> {
            if (allRaw.isEmpty())
                allRaw = fetchAll()
            return allRaw
        }

        suspend fun search(q: String): List<Program> {
            val tokens = q.split(Regex("\\s"))
            return getAll().map { program ->
                Pair(program, tokens.count { program.title.contains(it, ignoreCase = true) })
            }.sortedBy { -it.second }.mapNotNull { if (it.second > 0) it.first else null }
        }

        suspend fun routeFor(q: String?): String {
            if (q.isNullOrBlank())
                return "search_button"

            val res = search(q)
            return if (res.size == 1)
                res.first().uri
            else
                "search_button?q=${q}"
        }
    }
}
