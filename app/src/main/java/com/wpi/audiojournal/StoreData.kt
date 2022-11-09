package com.wpi.audiojournal

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.wpi.audiojournal.models.MenuItem
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class StoreData(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("AJODataStore")
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
             buttons.add(MenuItem(it.key.name, it.value.toString()))
         }
        return buttons
    }
}