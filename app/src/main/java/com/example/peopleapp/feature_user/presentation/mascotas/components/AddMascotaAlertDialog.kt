package com.example.peopleapp.feature_user.presentation.mascotas.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import com.example.peopleapp.Constants.Companion.ADD
import com.example.peopleapp.Constants.Companion.ADD_MASCOTA
import com.example.peopleapp.Constants.Companion.ANIMAL
import com.example.peopleapp.Constants.Companion.DISMISS
import com.example.peopleapp.Constants.Companion.RAZA
import com.example.peopleapp.feature_user.domain.model.Mascota
import kotlinx.coroutines.job

@Composable
fun AddMascotaAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addMascota: (mascota: Mascota) -> Unit
) {
    if (openDialog) {
        var animal by remember { mutableStateOf("") }
        var raza by remember { mutableStateOf("") }
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = { closeDialog },
            title = {
                Text(ADD_MASCOTA)
            },
            text = {
                Column {
                    TextField(
                        value = animal,
                        onValueChange = { animal = it },
                        placeholder = {
                            Text(ANIMAL)
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = raza,
                        onValueChange = { raza = it },
                        placeholder = {
                            Text(RAZA)
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val mascota = Mascota(0, animal, raza)
                        addMascota(mascota)
                    }) {
                    Text(ADD)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(DISMISS)
                }
            }
        )
    }
}