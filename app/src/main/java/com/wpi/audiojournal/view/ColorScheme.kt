package com.wpi.audiojournal.view

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.wpi.audiojournal.R
import com.wpi.audiojournal.models.MenuItem

class ColorScheme(val colors: List<Int>, val background: Int, val content: Int, val borders: Int = -1)

class AppColorSchemes(){
    var list1 = listOf<Int>(R.color.purple, R.color.salmon, R.color.orange, R.color.yellow, R.color.teal, R.color.blue)
    var scheme1 = ColorScheme(list1,R.color.gray, R.color.black, R.color.black)

    /*fun initColorSchemes(){
        var colorList1 = mutableListOf<Int>();

        colorList1.add(R.color.purple)
        colorList1.add(R.color.salmon)
        colorList1.add(R.color.orange)
        colorList1.add(R.color.yellow)
        colorList1.add(R.color.teal)
        colorList1.add(R.color.blue)

        scheme1 = ColorScheme(colorList1, R.color.gray, R.color.black, R.color.black)


    }*/

    fun getRainbowColor(itemTitle: String, index:Int): Int {

        if(itemTitle.contains("Search") || itemTitle.contains("Back")){
            return  R.color.white
        }else{

            val color = scheme1.colors.get(index%scheme1.colors.size)
            return color
        }

    }

    fun getBackground():Int{

        return scheme1.background
    }

    fun getBorder(): Int{
        return scheme1.borders
    }

    fun getContent(): Int{
        return scheme1.content
    }


}