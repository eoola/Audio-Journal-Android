package com.wpi.audiojournal

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.wpi.audiojournal.models.MenuItem
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class StoreData(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("DataStoreAJO")
        val title = stringPreferencesKey("title")
        val playTime = longPreferencesKey("playTime")
        val programURL = stringPreferencesKey("link")
        val colorIndex = intPreferencesKey("color")
    }

    suspend fun addFavorite(name: String, link: String){
        context.dataStore.edit { preferences ->
            preferences[stringPreferencesKey(name)] = link
        }
    }

    suspend fun deleteFavorite(name: String){
        context.dataStore.edit {
            it.remove(stringPreferencesKey(name))
        }
    }

    suspend fun isFavorite(name: String): Boolean {
        return context.dataStore.data.first().contains(stringPreferencesKey(name))
    }

     fun createButtons(): List<MenuItem> {
        var buttons: MutableList<MenuItem> = mutableListOf()
         val exampleData = runBlocking { context.dataStore.data.first() }

         exampleData.asMap().mapKeys {
             if(it.key.name != "title" && it.key.name != "playTime" && it.key.name != "link" && it.key.name != "color")
                buttons.add(MenuItem(it.key.name, it.value.toString()))
         }
        return buttons
    }

    suspend fun addLastPlayed(header: String, programLink: String, play: Long){
        context.dataStore.edit { preferences ->
            preferences[title] = header
            preferences[playTime] = play
            preferences[programURL] = programLink
        }
    }

    suspend fun addColorScheme(index: Int){
        context.dataStore.edit { preferences ->
            preferences[colorIndex] = index
        }
    }

     fun getPlayTime(): Long? {
        return runBlocking {context.dataStore.data.first()[playTime]}
    }

    fun getTitle(): String? {
        return runBlocking {context.dataStore.data.first()[title]}
    }

    fun getProgramLink(): String? {
        return runBlocking {context.dataStore.data.first()[programURL]}
    }

    fun getColorIndex(): Int? {
        return runBlocking {context.dataStore.data.first()[colorIndex]}
    }
}