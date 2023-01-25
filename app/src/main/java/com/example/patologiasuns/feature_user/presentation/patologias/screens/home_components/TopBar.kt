package com.example.patologiasuns.feature_user.presentation.patologias.screens.home_components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun TopBar(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            //.background(Color.Gray)
            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = typography.h5,
            color = Color.White
        )
    }
}