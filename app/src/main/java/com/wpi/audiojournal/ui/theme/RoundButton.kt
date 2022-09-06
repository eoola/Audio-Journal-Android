package com.wpi.audiojournal.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class RoundButtonParams {
    val widthMargin = 20
    val borderStroke = 3
    val height = 100


}
@Composable
fun RoundButton(text:String,
                modifier: Modifier=Modifier,
                onClick:()->Unit,
                borderColor: Color,
                backgroundColor: Color,
                contentColor: Color
                ){
    val params = RoundButtonParams()
    val context = LocalContext.current
    val displayMetrics = context.getResources().getDisplayMetrics()
    //val dpHeight = displayMetrics.heightPixels / displayMetrics.density;
    val dpWidth = displayMetrics.widthPixels / displayMetrics.density

    val w = dpWidth - params.widthMargin
    //val h = dpHeight - 3


    OutlinedButton(onClick = onClick,
        modifier = modifier.size(width = w.dp, height = params.height.dp),
        //modifier = Modifier.height(50),
        shape = CircleShape,
       // contentPadding = PaddingValues(horizontal = 50.dp, vertical = 20.dp),
        border = BorderStroke(params.borderStroke.dp, borderColor),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        )
    ) {
        Text(text = text
            //style = MaterialTheme.typography.h
            //modifier = Modifier.padding(10.dp)
        )
    }
}