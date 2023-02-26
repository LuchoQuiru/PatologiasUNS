package com.example.patologiasuns.feature_detalle.presentation.components

import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.peopleapp.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

/*@Preview
@Composable
fun t() {
    TopBar(nombre_patologia = "PATOLOGIA TEST", null)
}*/

@Composable
fun TopBar(
    nombre_patologia: String,
    takePermission: ActivityResultLauncher<String>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 10.dp)
        ){
            Text(
                text = nombre_patologia,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.surface
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .padding(end = 10.dp)
        ) {
            Image(
                modifier = Modifier
                    .clickable {
                        takePermission.launch(android.Manifest.permission.BLUETOOTH_CONNECT)
                    }
                    .size(25.dp, 25.dp)
                    .clip(RoundedCornerShape(6.dp)),
                painter = painterResource(id = R.drawable.blluetooth_connected),
                alignment = Alignment.BottomEnd,
                contentDescription = "",
                contentScale = ContentScale.Crop,
            )
        }
    }
}