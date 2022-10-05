package com.wpi.audiojournal.uikit

class LogicalNavigationGraph {

    fun nextScreen(current:String):String{
        var next = ""
        if(current.contains("Archive")){
            next = "program option"
        }else if(current.contains("option")){
            next = "program detail"
        }
        /*else if (current.contains("programs")){
            next = "detail programs"
        }*/

        return next
    }
}