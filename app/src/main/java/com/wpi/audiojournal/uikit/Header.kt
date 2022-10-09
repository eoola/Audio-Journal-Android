package com.wpi.audiojournal.uikit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.wpi.audiojournal.R
import com.wpi.audiojournal.view.AppColorSchemes

@Composable
fun Header(menuType: String, title: String, navController: NavController,hasBackButton:Boolean, hasFavorites: Boolean, airTime: String?=null, description: String?=null, colorsObj: AppColorSchemes ) {
    var yellow  = R.drawable.favorites_yellow
    var gray = R.drawable.favorites_gray


    Column() {
        val contentColor = colorResource(id =colorsObj.getContent())
        val bColor = colorResource(id =colorsObj.getBorder())
        var stroke = 0
        if(bColor != null){
            stroke = 4
        }
        if (hasBackButton) {
            val backColor = colorsObj.getRainbowColor("Back", -1)
            Button(
                modifier = Modifier
                    .padding(
                        horizontal = 5.dp,
                        vertical = 5.dp
                    )
                    .size(width = 60.dp, height = 50.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id =backColor)),
                shape = RoundedCornerShape(30),
                border = BorderStroke(stroke.dp, bColor),

                onClick = { navController.popBackStack() }
            ) {
                Text(
                    text = "Back",
                    style = MaterialTheme.typography.subtitle1,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    maxLines = 1,
                    color = contentColor,
                    modifier = Modifier
                        .padding(horizontal = 0.dp, vertical = 10.dp)
                        .fillMaxSize()
                )
            }
        }
    }

        Column(
            //modifier = Modifier.fillMaxSize(),
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val contentColor = colorsObj.getContent()
            if (menuType.contains("Home")) {
                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = stringResource(R.string.audioJournalTitle),
                    color = colorResource(id =contentColor),
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight = FontWeight.ExtraBold,

                    ),
                    fontSize = 30.sp
                )
            } else {

                Text(
                        modifier = Modifier.padding( horizontal = 20.dp),

                        text = title,
                        color = colorResource(id =contentColor),
                        style = MaterialTheme.typography.h5
                )


            }



            if (airTime != null) {
                Text(
                    modifier = Modifier,
                    text = "Airtime: $airTime",
                    color = colorResource(id =contentColor),

                )
            }

            if (description != null) {
                Text(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    text = description,
                    color = colorResource(id =contentColor),

                )


            }

            if (hasFavorites) {
                Row(modifier = Modifier.padding(20.dp)){
                    Text(
                        modifier = Modifier.padding(top=15.dp),
                        text = "Favorite: ",
                        color = colorResource(id =contentColor),
                    )
                    var icon = gray//track if marked or no
                    var marked = false
                    IconButton(onClick = {
                        if (!marked) {
                            icon = yellow

                        } else {
                            icon = gray
                        }
                        marked = !marked
                        /*TODO*/
                    }) {
                        Box(modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)){
                            Image(
                                painter = painterResource(icon),
                                contentDescription = "Favorites",
                                contentScale = ContentScale.Fit
                            )
                        }

                    }
                }

            }
        }

}