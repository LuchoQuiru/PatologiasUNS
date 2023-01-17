package com.example.patologiasuns.bottombarnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ActivitiesScreen(
    val route : String
){
    object AgregarPatologia : ActivitiesScreen(
        route = "agregarpatologia"
    )
}