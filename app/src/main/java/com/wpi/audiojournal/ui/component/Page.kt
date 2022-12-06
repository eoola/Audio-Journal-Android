package com.wpi.audiojournal.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wpi.audiojournal.ui.theme.LocalColorScheme

@Composable
fun PageSkeleton (
    header: String,
    modifier: Modifier = Modifier,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    content: @Composable ColumnScope.() -> Unit
) {
    Column (
        modifier.fillMaxSize().background(LocalColorScheme.current.background).padding(12.dp),
        horizontalAlignment = horizontalAlignment
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                text = header,
                style = MaterialTheme.typography.h5.copy(
                    fontWeight = FontWeight.ExtraBold,
                ),
                fontSize = 30.sp
            )
        }
        content(this)
    }


}