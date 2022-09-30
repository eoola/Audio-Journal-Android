package com.wpi.audiojournal.navigation

import com.wpi.audiojournal.MenuItem



class ArchiveDataObjects {
    var categories= mutableListOf<KeyValue>()
    var programs= mutableListOf<KeyValue>()
    var programInfo = mutableListOf<KeyValuesMany>()

    fun getMenuItems( key: String, screenType: String): MutableList<MenuItem> {
        var menuItems = mutableListOf<MenuItem>()
        if (screenType.equals("general program categories")){
            for(keyVal in categories){
                if(keyVal.nodeKey.equals(key)){
                    menuItems.add(MenuItem(keyVal.valueItem))
                }
            }
        }else if (screenType.equals("general programs")){
            for(keyVal in programs){
                if(keyVal.nodeKey.equals(key)){
                    menuItems.add(MenuItem(keyVal.valueItem))
                }
            }
        }

        return menuItems
    }

    fun getProgramInformation(key: String): MutableList<String>{
        for(keyVal in programInfo){
            if(keyVal.programKey.equals(key)){
                return keyVal.values;

            }
        }
        val list= mutableListOf<String>()
        return list
    }


}

class KeyValue (val nodeKey: String, val valueItem: String){

}

class KeyValuesMany (val programKey: String, val values: MutableList<String>) {

}