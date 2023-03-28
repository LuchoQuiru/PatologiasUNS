package com.example.patologiasuns.feature_detalle

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.patologiasuns.feature_detalle.presentation.components.*

@Composable
fun DetalleScreen(
    fn_boton_bluetooth : () -> Unit,
    id: Int,
) {
    DetallesContent(fn_boton_bluetooth = fn_boton_bluetooth)
}

