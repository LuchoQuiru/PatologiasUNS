package com.example.patologiasuns.feature_detalle.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Patologia",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.surface
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Pasos a seguir para tratar la patologia",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.surface
            )
        }
    }
}