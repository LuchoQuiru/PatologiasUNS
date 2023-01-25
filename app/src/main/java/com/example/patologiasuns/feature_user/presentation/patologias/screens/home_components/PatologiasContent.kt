package com.example.patologiasuns.feature_user.presentation.patologias.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.patologiasuns.feature_user.domain.repository.Patologias

@Composable
fun PatologiasContent(
    padding: PaddingValues,
    patologias: Patologias,
    navController : NavController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        items(patologias) { patologia ->
            PatologiasCard(
                patologia = patologia,
                onItemClicked = {
                    p -> navController
                    .navigate("detalles/${p.id}/${p.nombre}")
                }
            )
        }
        item{
            Spacer(modifier = Modifier.padding(50.dp))
        }
    }
}