package com.wpi.audiojournal.models

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.wpi.audiojournal.viewmodels.GeneralCategoryViewModel
import com.wpi.audiojournal.viewmodels.GeneralProgramsViewModel


class MenuItemFactory(val categoryViewModel: GeneralCategoryViewModel, val programsViewModel:GeneralProgramsViewModel ){

    var categoryMap=HashMap<String, Category>() // purpose: retrive information about category, i.e. api name to get programs

    var programMap = HashMap<String, Program>()

    var menuMap = HashMap<String, List<MenuItem>>() //purpose: retrieve menu item for screen

    var doneLoad= false

    @Composable
    fun initializeFactory(){
        categoryViewModel.loadCategories()
        val categories by categoryViewModel.uiState.collectAsState()
        val catMenu = categories.menuItems
        val catList = categories.categoryList
        for(c in catList){
            Log.d("TEST-CATLIST","NUM??")
            categoryMap.put(c.title, c)
            initProgramData(cat = c)
        }
        menuMap.put("categories", catMenu)

        
        doneLoad = true


    }
    
    @Composable
    fun initProgramData(cat:Category){
        programsViewModel.loadPrograms(cat.name)
        Log.d("TEST-PROGRAMS",cat.name)
        val programs = programsViewModel.uiState.collectAsState()
        val progMenu = programs.value.menuItems
        val progList = programs.value.programList
        for(p in progList){
            programMap.put(p.title,p)
        }
        menuMap.put("programs~${cat.title}", progMenu)

    }

    fun getCategories(): List<MenuItem>? {
        return menuMap.get("categories")
    }

    fun getCategoryName(title: String): String?{
        val cat = categoryMap.get(title)
        if(cat != null){
            return cat.name
        }else{
            return null
        }
    }

    fun getProgramsByCategory(category:String):List<MenuItem>?{
        return menuMap.get("programs~${category}")
    }



    /*lateinit var screenNavigationMap: ScreenNavigationMap

    fun init(){
        var map = HashMap<String, MutableList<Category>>()
        screenNavigationMap = ScreenNavigationMap(map)
    }

    fun getMenuItems(menuPage: String): MutableList<MenuItem>{
        var menuItems = mutableListOf<MenuItem>()
        var categories = screenNavigationMap.screenToCategory[menuPage]
        if (categories != null) {
            for(category in categories){
                var item = MenuItem(category.title)
                menuItems.add(item)
            }
        }

        return menuItems
    }*/



}


