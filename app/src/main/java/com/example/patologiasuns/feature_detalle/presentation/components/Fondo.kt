package com.example.patologiasuns.feature_detalle.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.peopleapp.R


@Preview
@Composable
fun Fondo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.mipmap.fonditojotapeje),
            contentDescription = "fondo",
            contentScale = ContentScale.FillBounds
        )
    }
}
