package com.wpi.audiojournal.uikit

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.wpi.audiojournal.R
import com.wpi.audiojournal.models.MenuItem
import com.wpi.audiojournal.models.MenuType
import com.wpi.audiojournal.navigation.Screens
import com.wpi.audiojournal.view.AppColorSchemes

@Composable
fun ButtonComponents(menuType:String,
                     menuItems: List<MenuItem>,
                     navController: NavController,
                     hasColorPallette: Boolean,
                     hasSearch: Boolean,
                     headerSpace: Int,
                     colorsObj: AppColorSchemes,
                     navDataName: HashMap<String, String>? = null){
    var search = 0
    var buttonsSpace = headerSpace

    Column() {
        val contentColor = colorResource(id =colorsObj.getContent())
        val bColor = colorResource(id =colorsObj.getBorder())
        var stroke = 0
        if(bColor != null){
            stroke = 2
        }
        if (hasSearch) {
            //SEARCH BAR Button
            search = headerSpace
            buttonsSpace = 10
            Column(modifier = Modifier.padding(top = 10.dp),) {
                Button(
                    modifier = Modifier
                        .padding(
                            horizontal = 1.dp,
                            vertical = 10.dp
                        )
                        .fillMaxWidth()
                        .size(width = 300.dp, height = 40.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id =colorsObj.getRainbowColor("Search Programs", -1))),
                    shape = CircleShape,
                    border = BorderStroke(stroke.dp, bColor),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Search Programs",
                        color = contentColor,
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }

        }
        LazyColumn(
            modifier = Modifier.padding(top = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            items(items = menuItems) { menuItem ->
                Button(
                    modifier = Modifier
                        .padding(
                            horizontal = 24.dp,
                            vertical = 5.dp
                        )
                        .fillMaxSize()
                        .size(width = 100.dp, height = 85.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id =colorsObj.getRainbowColor(menuItem.title, menuItems.indexOf(menuItem)))),
                    shape = CircleShape,
                    border = BorderStroke(stroke.dp, bColor),
                    onClick = {
                        // if(menuItem.title.equals("Archived Programs")){
                        //   navController.navigate("Archived Programs")
                        //}

                        var g = LogicalNavigationGraph()
                        var nextMenu = ""
                        if (menuType.contains("Home") ) {
                            Log.d("TEST", "NAV${menuItem.title}")
                            navController.navigate(menuItem.title)
                        }
                        else if(menuType.contains("Program Schedule")){
                            navController.navigate("${Screens.programScheduleScreen.route}/${menuItem.title}")
                        }
                        else {
                            nextMenu = g.nextScreen(menuType)

                            if(nextMenu.contains("detail")){
                                Log.d("TEST", "NAV${menuItem.title}")
                                navController.navigate("$nextMenu/${menuItem.title.replace(" ","_")}/${menuItem.name}/${menuItem.description}")
                            }else if(nextMenu.contains("media")){
                                navController.navigate("$nextMenu/${menuItem.title.replace(" ","_").replace("/", "~")}/${menuItem.url!!.replace("/", "~")}")

                            } else{
                                Log.d("TEST", "NAV${menuItem.title}")
                                navController.navigate("$nextMenu/${menuItem.title.replace(" ","_")}/${menuItem.name}")
                            }

                            //if(navDataName != null){
                                /*val name = navDataName[menuItem.title]
                                if(name != null){
                                    val nameArr = name.split("~")
                                    Log.d("TEST", "NAV${menuItem.title}")
                                    navController.navigate("$nextMenu/${menuItem.title}/${nameArr[0]}")
                                }else{
                                    Log.d("TEST", "OHOH no name")
                                }*/

                            //}else{


                           // }

                        }


                    }
                ) {
                    Text(
                        text = menuItem.title,
                        color = contentColor,
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }


        }


            if (hasColorPallette) {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(R.drawable.color_palette_icon),
                        contentDescription = "Color Palette Icon"
                    )
                }
            }

    }




}