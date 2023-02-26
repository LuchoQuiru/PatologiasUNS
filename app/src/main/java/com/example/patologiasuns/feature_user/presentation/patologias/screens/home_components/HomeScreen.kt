package com.example.patologiasuns.feature_user.presentation.patologias

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.patologiasuns.feature_user.PatologiasViewModel
import com.example.patologiasuns.feature_user.presentation.patologias.components.PatologiasContent
import com.example.patologiasuns.feature_user.presentation.patologias.screens.home_components.TopBar

@Composable
fun HomeScreen(
    viewModel: PatologiasViewModel = hiltViewModel(),
    navController: NavController
) {
    //Almaceno en una variable de estado, las mascotas obtenidas A TRAVES del viewmodel
    //Esto se relaciona con el patron observer *creo*
    val patologias by viewModel.patologias.collectAsState(initial = emptyList())

    TopBar(title = "Patologias")
    Spacer(modifier = Modifier.padding(30.dp))
    PatologiasContent(
        padding = PaddingValues(top = 60.dp),
        patologiasWithSteps = patologias,
        navController = navController
    )

}
