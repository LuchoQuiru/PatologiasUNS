package com.example.patologiasuns.feature_detalle

import androidx.activity.result.ActivityResultLauncher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.patologiasuns.feature_detalle.presentation.components.*

@Composable
fun DetalleScreen(
    viewModel: DetalleViewModel = hiltViewModel(),
    takePermission: ActivityResultLauncher<String>,
    id: Int,
) {
    val patologiaWithStep by viewModel.patologiaWithSteps.collectAsState(null)

    patologiaWithStep?.let{
        DetallesContent(patologiaWithStep!!,takePermission)
        //DetallesContent(patologiaWithStep!!)
    }
}

