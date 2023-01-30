package com.wpi.audiojournal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wpi.audiojournal.models.helpInfoMap
import com.wpi.audiojournal.ui.component.PageSkeleton

@Composable
fun HelpInfoView(uriString: String) {
    val info = helpInfoMap[uriString]
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp

    var textSize = 16
    PageSkeleton(header = info?.screenTitle ?: "") {
        info?.let { info ->

            LazyColumn{
                item{
                    Image(
                        painter = painterResource(id = info.icon),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(width = 200.dp, height = 100.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    if (info.screenTitle.contains("Audio Journal") && screenWidth < 500){
                        textSize = 15
                    }
                    Text(
                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp),
                        text = info.desc,
                        style = MaterialTheme.typography.subtitle1,
                        fontSize = textSize.sp
                    )
                    info.icon2?.let {
                        Image(
                            painter = painterResource(id = it),
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .size(width = 200.dp, height = 100.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                    }
                }

            }



        }
    }
}


