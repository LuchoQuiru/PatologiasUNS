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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.patologiasuns.feature_detalle.DetalleViewModel

@Preview
@Composable
fun BotonReproduccion(
    viewModel: DetalleViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    OutlinedButton(
        onClick = {
                  viewModel.reproducirSonido(context,1)
        },
        modifier = Modifier.size(50.dp),  //avoid the oval shape
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.Black),
        contentPadding = PaddingValues(0.dp),  //avoid the little icon
        colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colors.background)
    ) {
        Icon(Icons.Default.PlayArrow, contentDescription = "play")
    }
}
