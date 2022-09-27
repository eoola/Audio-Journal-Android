package com.wpi.audiojournal.data

import com.wpi.audiojournal.navigation.ArchiveDataObjects
import com.wpi.audiojournal.navigation.KeyValue
import com.wpi.audiojournal.navigation.KeyValuesMany

class DataStuff {
    fun initTest(): ArchiveDataObjects {
        val data = ArchiveDataObjects()
        data.categories.add(KeyValue("Local Newspaper", "A"))
        data.categories.add(KeyValue("Local Newspaper", "B"))
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
}