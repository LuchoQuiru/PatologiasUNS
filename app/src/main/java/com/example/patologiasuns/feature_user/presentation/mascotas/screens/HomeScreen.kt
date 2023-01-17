package com.example.patologiasuns.feature_user.presentation.mascotas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.patologiasuns.feature_user.presentation.mascotas.components.MascotasContent
import com.example.patologiasuns.feature_user.presentation.mascotas.screens.home_components.TopBar

@Composable
fun HomeScreen(
    viewModel: MascotasViewModel = hiltViewModel()
) {
    //Almaceno en una variable de estado, las mascotas obtenidas A TRAVES del viewmodel
    //Esto se relaciona con el patron observer *creo*
    val mascotas by viewModel.mascotas.collectAsState(initial = emptyList())

    TopBar(title = "Patologias")
    Spacer(modifier = Modifier.padding(15.dp))
    MascotasContent(
        padding = PaddingValues(top = 60.dp),
        mascotas = mascotas
    )
}
