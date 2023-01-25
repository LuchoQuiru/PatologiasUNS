package com.example.patologiasuns.feature_user.presentation.patologias.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.example.patologiasuns.Constants.Companion.ADD_MASCOTA

@Composable
fun AddMascotaFloatingActionButton(
    openDialog: () -> Unit
) {
    FloatingActionButton(
        onClick = openDialog,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = ADD_MASCOTA
        )

    }
}