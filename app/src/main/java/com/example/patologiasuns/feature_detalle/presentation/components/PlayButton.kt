package com.example.patologiasuns.feature_detalle.presentation.components

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.patologiasuns.feature_detalle.DetalleViewModel
import com.example.patologiasuns.ui.theme.PeopleAppTheme


@Composable
fun prev() {
    PeopleAppTheme{
        DisabledButton()
    }
}

@Composable
fun PlayButton(
    viewModel: DetalleViewModel = hiltViewModel()
) {
    val reproduciendoSonidoActualmente = viewModel.sonidoReproduciendoseActualmente.value

    val context : Context =  LocalContext.current
    val charRecibido = viewModel.charRecibido.observeForever({
        if(it.equals("a"))
            viewModel.reproducirSonido(context,1)
    })



    if(reproduciendoSonidoActualmente)
        DisabledButton()
    else
        EnabledButton()
}

@Composable
fun EnabledButton(
    viewModel: DetalleViewModel = hiltViewModel()
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

@Composable
fun DisabledButton() {
    OutlinedButton(
        onClick = {},
        modifier = Modifier.size(50.dp),  //avoid the oval shape
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.Black),
        contentPadding = PaddingValues(0.dp),  //avoid the little icon
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colors.background
        )
    ) {
        Icon(Icons.Default.ThumbUp, contentDescription = "Reproduciendo")
    }
}
