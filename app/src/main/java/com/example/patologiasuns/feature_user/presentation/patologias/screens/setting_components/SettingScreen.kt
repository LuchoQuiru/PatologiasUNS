package com.example.patologiasuns.feature_user.presentation.patologias

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

import androidx.hilt.navigation.compose.hiltViewModel
import com.example.patologiasuns.feature_sounds.SoundManager
import com.example.patologiasuns.feature_sounds.domain.model.Sound
import com.example.patologiasuns.feature_user.PatologiasViewModel

import com.example.patologiasuns.feature_user.presentation.patologias.components.AddMascotaAlertDialog
import com.example.patologiasuns.feature_user.presentation.patologias.components.AddMascotaFloatingActionButton


@Composable
fun SettingScreen(
    viewModel: PatologiasViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize())
    {
        Estructura(viewModel)
    }
}

@Composable
private fun Estructura(viewModel: PatologiasViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Home!")

        AddMascotaFloatingActionButton(
            openDialog = {
                viewModel.openDialog()
            })

        AddMascotaAlertDialog(
            openDialog = viewModel.openDialog,
            closeDialog = { viewModel.closeDialog() },
            addPatologia = { patologia ->
                viewModel.addPatologia(patologia)
            }
        )
    }
}
