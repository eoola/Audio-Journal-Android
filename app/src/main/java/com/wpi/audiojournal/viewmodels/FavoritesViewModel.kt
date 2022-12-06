package com.wpi.audiojournal.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wpi.audiojournal.StoreData
import com.wpi.audiojournal.models.MenuItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class FavoritesViewModel(private val storage: StoreData): ViewModel(){

      fun addFavorite(name: String, link: String){
          viewModelScope.launch(Dispatchers.IO) {
              storage.addFavorite(name, link)
          }
    }

     fun deleteFavorite(name: String){
         viewModelScope.launch(Dispatchers.IO) {
             storage.deleteFavorite(name)
         }
    }

     fun isFavorite(name: String): Boolean =
         runBlocking(Dispatchers.IO) {
             return@runBlocking storage.isFavorite(name)
         }

    fun createFavoritesButtons(): List<MenuItem>{
        return storage.createButtons()
    }

    fun addLastPlayed(title: String, programLink: String, play: Long){
        viewModelScope.launch(Dispatchers.IO){
            storage.addLastPlayed(title, programLink, play)
        }
    }

    fun addColorScheme(index: Int){
        viewModelScope.launch(Dispatchers.IO){
            storage.addColorScheme(index)
        }
    }

    fun getPlayTime(): Long? {
        return storage.getPlayTime()
    }

    fun getTitle(): String? {
        return storage.getTitle()
    }

    fun getProgramLink(): String? {
        return storage.getProgramLink()
    }

    fun getColorScheme(): Int? {
        return storage.getColorIndex()
    }
}