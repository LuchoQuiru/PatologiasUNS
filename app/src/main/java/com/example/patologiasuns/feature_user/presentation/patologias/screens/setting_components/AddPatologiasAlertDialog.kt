package com.example.patologiasuns.feature_user.presentation.patologias.components

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
import com.example.patologiasuns.Constants.Companion.ADD
import com.example.patologiasuns.Constants.Companion.ADD_MASCOTA
import com.example.patologiasuns.Constants.Companion.DETALLE
import com.example.patologiasuns.Constants.Companion.DISMISS
import com.example.patologiasuns.Constants.Companion.PATOLOGIA
import com.example.patologiasuns.feature_user.domain.model.Patologia
import kotlinx.coroutines.job

@Composable
fun AddMascotaAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addPatologia: (patologia: Patologia) -> Unit
) {
    if (openDialog) {
        var patologia by remember { mutableStateOf("") }
        var detalle by remember { mutableStateOf("") }
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = { closeDialog },
            title = {
                Text(ADD_MASCOTA)
            },
            text = {
                Column {
                    TextField(
                        value = patologia,
                        onValueChange = { patologia = it },
                        placeholder = {
                            Text(PATOLOGIA)
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
                        value = detalle,
                        onValueChange = { detalle = it },
                        placeholder = {
                            Text(DETALLE)
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val patologia = Patologia(0, patologia, detalle)
                        addPatologia(patologia)
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