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
}