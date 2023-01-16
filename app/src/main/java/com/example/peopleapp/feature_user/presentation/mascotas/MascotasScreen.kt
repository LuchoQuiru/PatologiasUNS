package com.example.peopleapp.feature_user.presentation.mascotas

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.peopleapp.Constants.Companion.MASCOTAS_SCREEN
import com.example.peopleapp.feature_user.presentation.mascotas.components.AddMascotaAlertDialog
import com.example.peopleapp.feature_user.presentation.mascotas.components.AddMascotaFloatingActionButton
import com.example.peopleapp.feature_user.presentation.mascotas.components.MascotasContent
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun MascotasScreen(
    viewModel: MascotasViewModel = hiltViewModel()
) {
    //Almaceno en una variable de estado, las mascotas obtenidas A TRAVES del viewmodel
    //Esto se relaciona con el patron observer *creo*
    val mascotas by viewModel.mascotas.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(MASCOTAS_SCREEN)
            })
        },
        content = { padding ->
            MascotasContent(
                padding = padding,
                mascotas = mascotas
            )
            AddMascotaAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addMascota = { mascota ->
                    viewModel.addMascota(mascota)
                }
            )
        },
        floatingActionButton = {
            AddMascotaFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}
