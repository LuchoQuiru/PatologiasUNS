package com.example.patologiasuns.feature_user.presentation.mascotas.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.patologiasuns.feature_user.domain.repository.Mascotas

@Composable
fun MascotasContent(
    padding: PaddingValues,
    mascotas: Mascotas
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        items(mascotas) { mascota ->
            MascotaCard(
                mascota = mascota
            )
        }
    }
}