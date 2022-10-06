package com.wpi.audiojournal.models



class MenuItemFactory {

    lateinit var screenNavigationMap: ScreenNavigationMap

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
    }



}


