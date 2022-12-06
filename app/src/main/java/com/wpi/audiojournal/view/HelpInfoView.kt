package com.wpi.audiojournal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.wpi.audiojournal.models.helpInfoMap
import com.wpi.audiojournal.ui.component.PageSkeleton
import com.wpi.audiojournal.ui.theme.LocalColorScheme

@Composable
fun HelpInfoView(uriString: String) {
    val info = helpInfoMap[uriString]
    PageSkeleton(header = info?.screenTitle ?: "") {
        info?.let { info ->
            Image(
                painter = painterResource(id = info.icon),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(width = 200.dp, height = 100.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                text = info.desc,
                style = MaterialTheme.typography.subtitle1,
                color = LocalColorScheme.current.pageContent,
            )
            info.icon2?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.size(width = 200.dp, height = 100.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}


