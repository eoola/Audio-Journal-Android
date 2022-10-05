package com.wpi.audiojournal.data

import com.wpi.audiojournal.models.CategoriesDTO
import com.wpi.audiojournal.models.Category
import com.wpi.audiojournal.models.MenuItemFactory
import com.wpi.audiojournal.models.ScreenNavigationMap
import com.wpi.audiojournal.navigation.ArchiveDataObjects
import com.wpi.audiojournal.navigation.KeyValue
import com.wpi.audiojournal.navigation.KeyValuesMany

class DataStuff {
    var factory = MenuItemFactory()

    var catMap = HashMap<String, Category>()
    lateinit var data: CategoriesDTO

    fun initTest() {
        var map = HashMap<String, MutableList<Category>>()
        var list = mutableListOf<Category>()


        var local = Category("Local Newspaper", "Local Newspaper", "")
        var retail = Category("Retail Circulars and Sales", "Retail Circulars and Sales", "")
        var special = Category("Specialty Program", "Specialty Program", "")

        list.add(local)
        list.add(retail)
        list.add(special)

        map.put("Archived Programs", list)

        list = mutableListOf<Category>()


        var cA = Category("A", "A", "jnegrkngkerlmg;lea")
        var cB = Category("B", "B", "kfm,.wamel;fmawg.e")
        var cC = Category("C", "C", "malf.mkwemgflw'")
        var cD = Category("D", "D", "ROTIOERGNVSM,Sl>")
        var cE = Category("E", "E", "amkd,.amcvlwea")
        var cF = Category("F", "F", "oerinmaenkwl")
        list.add(cA)
        list.add(cB)
        list.add(cC)
        map.put("Local Newspaper", list)

        list = mutableListOf<Category>()
        list.add(cD)
        list.add(cE)
        map.put("Retail Circulars and Sales", list)


        list = mutableListOf<Category>()
        list.add(cF)
        map.put("Specialty Program", list)


        list = mutableListOf<Category>()
        var cA1 = Category("A1", "A1", "")
        var cA2 = Category("A2", "A2", "")
        var cA3 = Category("A3", "A3", "")

        list.add(cA1)
        list.add(cA2)
        list.add(cA3)
        map.put("A", list)

        list = mutableListOf<Category>()
        var cB1 = Category("B1", "B1", "")
        list.add(cB1)
        map.put("B", list)

        list = mutableListOf<Category>()
        var cC1 = Category("C1", "C1", "")
        var cC2 = Category("C2", "C2", "")
        list.add(cC1)
        list.add(cC2)
        map.put("C", list)

        list = mutableListOf<Category>()
        var cD1 = Category("D1", "D1", "")
        list.add(cD1)
        map.put("D", list)

        list = mutableListOf<Category>()
        var cE1 = Category("E1", "E1", "")
        list.add(cE1)
        map.put("E", list)


        list = mutableListOf<Category>()
        var cF1 = Category("F1", "F1", "")
        list.add(cF1)
        map.put("F", list)


        factory.init()
        var sNav = ScreenNavigationMap(map)
        factory.screenNavigationMap = sNav

        catMap.put("A", cA)
        catMap.put("B", cB)
        catMap.put("C", cC)
        catMap.put("D", cD)
        catMap.put("E", cE)
        catMap.put("F", cF)
        catMap.put("A1", cA1)
        catMap.put("A2", cA2)
        catMap.put("A3", cA3)
        catMap.put("B1", cB1)
        catMap.put("C1", cC1)
        catMap.put("C2", cC2)
        catMap.put("D1", cD1)
        catMap.put("E1", cE1)
        catMap.put("F1", cF1)

        data = CategoriesDTO(catMap)

    }

    fun getNav(): MenuItemFactory{
        return factory
    }

    fun getCat(): CategoriesDTO{
        return data
    }
}
       // map.screenToCategory
        //(KeyValue("Local Newspaper", "A"))

       /* data.categories.add(KeyValue("Local Newspaper", "B"))
        data.categories.add(KeyValue("Local Newspaper", "C"))
        data.categories.add(KeyValue("Retail Circulars and Sales", "D"))
        data.categories.add(KeyValue("Retail Circulars and Sales", "E"))
        data.categories.add(KeyValue("Specialty Program", "F"))

        data.programs.add(KeyValue("A", "A1"))
        data.programs.add(KeyValue("A", "A2"))
        data.programs.add(KeyValue("A", "A3"))
        data.programs.add(KeyValue("B", "B1"))
        data.programs.add(KeyValue("C", "C1"))
        data.programs.add(KeyValue("C", "C2"))
        data.programs.add(KeyValue("D", "D1"))
        data.programs.add(KeyValue("E", "E1"))
        data.programs.add(KeyValue("F", "F1"))

        val listA = mutableListOf<String>()
        listA.add("Monday 6:00 PM")
        listA.add("Description goes here. eklfmwk")

        val listB = mutableListOf<String>()
        listB.add("Monday 7:00 PM")
        listB.add("Description goes here. jieklrmwrnmkwem,")

        val listC = mutableListOf<String>()
        listC.add("Monday 8:00 PM")
        listC.add("Description goes here. smka,dmdlakd;we")

        val listD = mutableListOf<String>()
        listD.add("Monday 5:00 PM")
        listD.add("Description goes here. mkdlsjflifjwifj")

        val listE = mutableListOf<String>()
        listE.add("Monday 4:00 PM")
        listE.add("Description goes here. kmcalsjdlado")

        val listF = mutableListOf<String>()
        listF.add("Monday 1:00 PM")
        listF.add("Description goes here. anfm ,e asdnlwkeklw sam,fnklaw")

        data.programInfo.add(KeyValuesMany("A", listA))
        data.programInfo.add(KeyValuesMany("B", listB))
        data.programInfo.add(KeyValuesMany("C", listC))
        data.programInfo.add(KeyValuesMany("D", listD))
        data.programInfo.add(KeyValuesMany("E", listE))
        data.programInfo.add(KeyValuesMany("F", listF))

        return data
    }
}*/