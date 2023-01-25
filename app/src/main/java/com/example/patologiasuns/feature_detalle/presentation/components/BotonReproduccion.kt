package com.example.patologiasuns.feature_detalle.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun BotonReproduccion() {
    OutlinedButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.size(50.dp),  //avoid the oval shape
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.Black),
        contentPadding = PaddingValues(0.dp),  //avoid the little icon
        colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colors.background)
    ) {
        Icon(Icons.Default.PlayArrow, contentDescription = "play")
    }
}
