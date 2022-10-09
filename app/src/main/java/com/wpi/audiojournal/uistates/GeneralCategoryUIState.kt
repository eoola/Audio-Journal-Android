package com.wpi.audiojournal.uistates

import com.wpi.audiojournal.models.CategoriesDTO
import com.wpi.audiojournal.models.Category
import com.wpi.audiojournal.models.MenuItem

class GeneralCategoryUIState (
    var menuItems: List<MenuItem> = listOf(),
    var categoryList: List<Category> = listOf()
)